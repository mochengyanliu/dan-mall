package com.dan.danauth.controller;

import com.dan.danauth.aop.EagleEye;
import com.dan.danauth.service.LoginService;
import com.dan.dancommon.base.BaseRequestModel;
import com.dan.dancommon.base.BaseResponseModel;
import com.dan.dancommon.constants.RespCode;
import com.dan.dancommon.constants.RespMsg;
import com.dan.dancommon.util.RedisUtil;
import com.dan.dancommon.util.VerifyUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lijun
 * @Description 登陆控制器类
 * @Date 2020-06-15 3:26 下午
 **/

@Log4j2
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    RedisUtil redisUtil;

    @EagleEye(desc = "后台登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponseModel<Object> login(@RequestBody BaseRequestModel request, HttpServletRequest httpRequest) {
        // 用户名
        String account = request.getReqData().getString("account");
        // 密码
        String password = request.getReqData().getString("password");
        // 验证码
        String code = request.getReqData().getString("code");
        // 验证值
        String pCode = request.getReqData().getString("pCode");
        BaseResponseModel<Object> response = loginService.login(account,password,code,pCode);
        return response;
    }

    @RequestMapping(value = "/createImg", method = RequestMethod.GET)
    public void createImg(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg"); //设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache"); //设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            VerifyUtil randomValidateCode = new VerifyUtil();
            String randomString = randomValidateCode.getRandcode(response); //输出验证码图片
            //将生成的随机验证码存放到redis中
            redisUtil.set(request.getParameter("pCode"), randomString, 30 * 60);
        } catch (Exception e) {
            log.error("获取验证码异常：", e);
        }
    }

    @EagleEye(desc = "微信登陆")
    @RequestMapping(value = "/loginByPhone", method = RequestMethod.POST)
    public BaseResponseModel<Object> loginByPhone(@RequestBody BaseRequestModel request, HttpServletRequest httpRequest) {
        // 用户名
        String name = request.getReqData().getString("phone");
        // 验证码
        String code = request.getReqData().getString("code");
        // 验证值
        String pCode = request.getReqData().getString("pCode");
        BaseResponseModel<Object> response = loginService.loginByPhone(name,code,pCode);
        return response;
    }

    @RequestMapping(value = "/getCode", method = RequestMethod.GET)
    public BaseResponseModel<Object> getCode(HttpServletRequest request) {
        BaseResponseModel<Object> response= new BaseResponseModel<>();
        int code = (int)((Math.random()*9+1)*100000);
        redisUtil.set(request.getParameter("pCode"), code, 30 * 60);
        int count = loginService.checkPhone(request.getParameter("pCode"));
        if (count > 0){
            Map<String, Object> map = new HashMap<>();
            map.put("code", code);
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
            response.setRepData(map);
        } else {
            response.setRepCode(RespCode.LOGIN_PHONE_WRONG_ERROR);
            response.setRepMsg(RespMsg.LOGIN_PHONE_WRONG_ERROR_MSG);
            return response;
        }
        return response;
    }
}
