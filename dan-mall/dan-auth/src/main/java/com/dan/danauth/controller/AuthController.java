package com.dan.danauth.controller;

import com.dan.danauth.aop.EagleEye;
import com.dan.danauth.dto.AuthEntityDTO;
import com.dan.danauth.entity.AuthEntity;
import com.dan.danauth.entity.RoleEntity;
import com.dan.danauth.service.AuthService;
import com.dan.danauth.vo.AuthPageVO;
import com.dan.dancommon.base.BaseRequestModel;
import com.dan.dancommon.base.BaseRequestModelII;
import com.dan.dancommon.base.BaseResponseModel;
import com.dan.dancommon.constants.RespCode;
import com.dan.dancommon.constants.RespMsg;
import com.dan.dancommon.util.StringUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description 权限控制器类
 * @Date 2020-06-16 11:14 上午
 **/

@Log4j2
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @EagleEye(desc = "新增权限接口")
    @RequestMapping("/insertAuth")
    public BaseResponseModel<Object> insertAuth(@RequestBody BaseRequestModelII<AuthEntity> request){
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        request.getReqData().setCreateUserId(request.getUserId());
        int count = authService.insertAuth(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else {
            response.setRepCode(RespCode.INSERT_AUTH_ERROR);
            response.setRepMsg(RespMsg.INSERT_AUTH_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "修改权限接口")
    @RequestMapping(value = "/updateAuth", method = RequestMethod.POST)
    public BaseResponseModel<Object> updateAuth(@RequestBody BaseRequestModelII<AuthEntity> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        request.getReqData().setUpdateUserId(request.getUserId());
        int count = authService.updateAuth(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else {
            response.setRepCode(RespCode.UPDATE_AUTH_ERROR);
            response.setRepMsg(RespMsg.UPDATE_AUTH_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "修改权限状态")
    @RequestMapping(value = "/updateAuthStatus", method = RequestMethod.POST)
    public BaseResponseModel<Object> updateAuthStatus(@RequestBody BaseRequestModel request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        List<Integer> list;
        if (!StringUtil.isEmpty(request.getReqData().get("ids"), true)) {
            list = (List<Integer>) request.getReqData().get("ids");
        } else {
            response.setRepCode(RespCode.UPDATE_ROLE_STATUS_ERROR);
            response.setRepMsg(RespMsg.UPDATE_ROLE_STATUS_ERROR_MSG);
            return response;
        }
        if (list == null || list.size() == 0) {
            response.setRepCode(RespCode.UPDATE_ROLE_STATUS_ERROR);
            response.setRepMsg(RespMsg.UPDATE_ROLE_STATUS_ERROR_MSG);
            return response;
        }
        int count = authService.updateAuthStatus(list, request.getReqData().getInteger("status"));
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else if (count == -1){
            response.setRepCode(RespCode.UPDATE_STATUS_CHECK_AUTH_ERROR);
            response.setRepMsg(RespMsg.UPDATE_STATUS_CHECK_AUTH_ERROR_MSG);
        } else {
            response.setRepCode(RespCode.UPDATE_AUTH_STATUS_ERROR);
            response.setRepMsg(RespMsg.UPDATE_AUTH_STATUS_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "查询权限列表")
    @RequestMapping(value = "/selectAuthList", method = RequestMethod.POST)
    public BaseResponseModel<Object> selectAuthList(@RequestBody BaseRequestModelII<AuthPageVO> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        Map<String, Object> map = authService.selectAuthList(request.getReqData());
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepData(map);
        return response;
    }

    @EagleEye(desc = "查询权限树")
    @RequestMapping(value = "/selectAuthTree", method = RequestMethod.POST)
    public BaseResponseModel<Object> selectAuthTree() {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        Map<String, Object> map = new HashMap();
        List<AuthEntityDTO> authEntityDTOS = authService.selectAuthTree();
        map.put("authEntityDTOS", authEntityDTOS);
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepData(map);
        return response;
    }

    @EagleEye(desc = "查询所有权限接口")
    @RequestMapping(value = "/selectAllAuth", method = RequestMethod.POST)
    public BaseResponseModel<Object> selectAllAuth() {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        List<AuthEntity> authEntities = authService.selectAllAuth();
        Map<String, Object> map = new HashMap<>();
        map.put("authEntities", authEntities);
        response.setRepData(map);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepCode(RespCode.SUCCESS);
        return response;
    }
}
