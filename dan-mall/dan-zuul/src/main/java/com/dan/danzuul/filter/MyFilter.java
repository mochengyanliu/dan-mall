package com.dan.danzuul.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dan.dancommon.base.BaseResponseModel;
import com.dan.dancommon.constants.RespCode;
import com.dan.dancommon.constants.RespMsg;
import com.dan.dancommon.util.GetIPAddrUtil;
import com.dan.dancommon.util.MD5Util;
import com.dan.dancommon.util.RedisUtil;
import com.dan.dancommon.util.StringUtil;
import com.dan.danzuul.entity.DictEntity;
import com.dan.danzuul.service.SkipInterface;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Log4j2
@Component
public class MyFilter extends com.netflix.zuul.ZuulFilter {

    @Value("${timestamp.validate.limit:3000}")
    private String validateLimit;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    SkipInterface skipInterface;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        BaseResponseModel responseModel = new BaseResponseModel();
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String requestUrl = request.getRequestURI(); //请求路径

        log.info(String.format("收到来自IP为 %s 的请求%s request to %s", GetIPAddrUtil.getIpAddress(request), request.getMethod(), request.getRequestURL().toString()));

        // 是否跳过验证
        if (skipAllFilters(requestUrl)) {
            log.info("跳过所有验证");
            return true;
        }

        log.info("开始验证");

        String requestParams = getRequestParams(request); //请求参数
        log.info("请求参数：" + requestParams);
        StringBuilder returnParam = new StringBuilder();
        // 基本参数校验
        if (!validateParams(requestUrl, requestParams, returnParam)) {
            log.warn("参数验证失败");
            responseModel.setRepCode(RespCode.VALIDATE_PARAMS_ERROR);
            responseModel.setRepMsg(RespMsg.VALIDATE_PARAMS_ERROR_MSG + "," + returnParam);
            responseModel.setRepData("");
            getContextForError(requestContext, responseModel);
            return false;
        }


        log.debug("参数验证通过");
        JSONObject parameterMap = JSON.parseObject(requestParams); // 格式化请求参数

        // 验证时间戳
        if (Math.abs(new Date().getTime() / 1000 - Long.parseLong(parameterMap.getString("time"))) > Integer.parseInt(validateLimit)) {
            log.warn("时间戳校验不通过");
            responseModel.setRepCode(RespCode.VALIDATE_TIME_ERROR);
            responseModel.setRepMsg(RespMsg.VALIDATE_TIME_ERROR_MSG);
            responseModel.setRepData("");
            getContextForError(requestContext, responseModel);
            return false;
        }

        log.debug("时间戳校验通过");

        // 验证签名
        if (!validateSign(requestUrl, requestParams)) {
            log.warn("签名校验不通过");
            responseModel.setRepCode(RespCode.VALIDATE_SING_ERROR);
            responseModel.setRepMsg(RespMsg.VALIDATE_SING_ERROR_MSG);
            responseModel.setRepData("");
            getContextForError(requestContext, responseModel);
            return false;
        }

        log.debug("签名校验通过");

        // 校验token
        if (!validateToken(requestUrl, parameterMap)) {
            log.warn("token校验不通过");
            responseModel.setRepCode(RespCode.VALIDATE_TOKEN_ERROR);
            responseModel.setRepMsg(RespMsg.VALIDATE_TOKEN_ERROR_MSG);
            responseModel.setRepData("");
            getContextForError(requestContext, responseModel);
            return false;
        }

        log.debug("token校验通过");
        return true;
    }

    //获取请求参数，适用于POST请求/GET请求，以及参数拼接在URL后面的POST请求
    private String getRequestParams(HttpServletRequest request) {
        String requestParams = null;
        String requestMethod = request.getMethod();
        StringBuilder params = new StringBuilder();
        Enumeration<String> names = request.getParameterNames();
        if (requestMethod.equals("GET")) {
            while (names.hasMoreElements()) {
                String name = names.nextElement();
                params.append(name);
                params.append("=");
                params.append(request.getParameter(name));
                params.append("&");
            }
            requestParams = params.delete(params.length() - 1, params.length()).toString();
        } else {
            Map<String, String> res = new HashMap<>();
            Enumeration<?> temp = request.getParameterNames();
            if (null != temp) {
                while (temp.hasMoreElements()) {
                    String en = (String) temp.nextElement();
                    String value = request.getParameter(en);
                    res.put(en, value);
                }
                requestParams = JSON.toJSONString(res);
            }
            if (StringUtil.isEmpty(requestParams, true) || "{}".equals(requestParams)) {
                BufferedReader br = null;
                StringBuilder sb = new StringBuilder("");
                try {
                    br = request.getReader();
                    String str;
                    while ((str = br.readLine()) != null) {
                        sb.append(str);
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (null != br) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                requestParams = sb.toString();
            }
        }
        return requestParams;
    }

    private RequestContext getContextForError(RequestContext ctx, BaseResponseModel responseModel) {
        RequestContext requestContext = ctx;
        ctx.setResponseBody(responseModel.toJsonString());
        ctx.setSendZuulResponse(false);
        ctx.getResponse().setContentType("text/html;charset=UTF-8");
        ctx.getResponse().setContentType(String.valueOf(MediaType.APPLICATION_JSON));
        return requestContext;
    }


    // 无需验证的接口
    private boolean skipAllFilters(String requestUrl) {
        Object object = redisUtil.get("skip");
        String skip = "";
        if (object == null) {
            List<DictEntity> dictEntityList = skipInterface.selectDictListByTypeId(1);
            if (dictEntityList != null && dictEntityList.size() > 0) {
                skip = StringUtils.join(dictEntityList.stream().map(DictEntity::getDictValue).collect(Collectors.toList()), "|");
            }
        } else {
            skip = object.toString();
        }
        log.info(skip);
        redisUtil.set("skip", skip, 30 * 60);
        boolean isSkip = false;
        if (Pattern.matches(skip, requestUrl)) {
            isSkip = true;
        }
        return isSkip;
    }

    // 请求参数校验
    private boolean validateParams(String requestUrl, String requestParams, StringBuilder returnParam) {
        if (StringUtil.isEmpty(requestParams, true)) {
            log.warn("请求参数为空");
            returnParam.append("请求参数为空");
            return false;
        }
        JSONObject parameterMap = JSON.parseObject(requestParams); // 格式化请求参数

        // 过滤不需要校验token的接口
        String skip = "";
        if (!Pattern.matches(skip, requestUrl)) {
            if (StringUtil.isEmpty(parameterMap.getString("token"), true)) {
                log.warn("token为空");
                returnParam.append("token为空");
                return false;
            }
        }

        if (StringUtil.isEmpty(parameterMap.getString("sign"), true)) {
            log.warn("sign为空");
            returnParam.append("sign为空");
            return false;
        } else if (StringUtil.isEmpty(parameterMap.getString("userId"), true)) {
            log.warn("userId为空");
            returnParam.append("userId为空");
            return false;
        } else if (StringUtil.isEmpty(parameterMap.getString("time"), true)) {
            log.warn("time为空");
            returnParam.append("time为空");
            return false;
        }
        return true;
    }

    // 签名校验
    private boolean validateSign(String requestUrl, String requestParams) {
        JSONObject jsonObject = JSONObject.parseObject(requestParams);
        String baseSignMsg = "";
        // 过滤不需要校验token的接口
        StringBuffer buffer = new StringBuffer();

        String reqDate = requestParams.substring(requestParams.indexOf("{", 2), requestParams.lastIndexOf("}", requestParams.lastIndexOf("}") - 1) + 1);
        if (Pattern.matches(buffer.toString(), requestUrl)) {
            baseSignMsg = "reqData=" + reqDate + "&time=" + jsonObject.get("time");
        } else {
            baseSignMsg = "reqData=" + reqDate + "&time=" + jsonObject.get("time") + "&token=" + jsonObject.get("token");
        }
        if (MD5Util.getMD5Code(baseSignMsg).equalsIgnoreCase(jsonObject.getString("sign"))) {
            return true;
        }
        return false;
    }

    // 校验token
    private boolean validateToken(String requestUrl, JSONObject parameterMap) {
        // 过滤不需要校验token的接口
        StringBuffer buffer = new StringBuffer();

        if (!Pattern.matches(buffer.toString(), requestUrl)) {
            if (StringUtil.isEmpty(redisUtil.get(parameterMap.getString("userId")), true)) {
                log.warn("token失效");
                return false;
            }
            if (!parameterMap.getString("token").equals(redisUtil.get(parameterMap.getString("userId")))) {
                log.warn("token不正确");
                return false;
            }
        }
        return true;
    }
}
