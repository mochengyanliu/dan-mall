package com.dan.danbusiness.controller;

import com.dan.danbusiness.aop.EagleEye;
import com.dan.danbusiness.entity.UserEntity;
import com.dan.danbusiness.service.UserService;
import com.dan.danbusiness.vo.UserPageVo;
import com.dan.dancommon.base.BaseRequestModelII;
import com.dan.dancommon.base.BaseResponseModel;
import com.dan.dancommon.constants.RespCode;
import com.dan.dancommon.constants.RespMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author lijun
 * @Description 用户控制类
 * @Date 2020-06-23 2:34 下午
 **/

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理模块")
public class UserController {

    @Autowired
    private UserService userService;

    @EagleEye(desc = "注册用户")
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    @ApiOperation(value = "注册用户", notes = "")
    public BaseResponseModel<Object> registerUser(@RequestBody BaseRequestModelII<UserEntity> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        request.getReqData().setCreateUser(request.getUserId());
        int count = userService.registerUser(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else if (count == -1) {
            response.setRepCode(RespCode.REGISTER_USER_ACCOUNT_REPEAT_ERROR);
            response.setRepMsg(RespMsg.REGISTER_USER_ACCOUNT_REPEAT_ERROR_MSG);
        } else if (count == -2){
            response.setRepCode(RespCode.REGISTER_USER_PHONE_REPEAT_ERROR);
            response.setRepMsg(RespMsg.REGISTER_USER_PHONE_REPEAT_ERROR_MSG);
        } else {
            response.setRepCode(RespCode.REGISTER_USE_ERROR);
            response.setRepMsg(RespMsg.REGISTER_USE_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "修改用户")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户", notes = "")
    public BaseResponseModel<Object> updateUser(@RequestBody BaseRequestModelII<UserEntity> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        request.getReqData().setUpdateUser(request.getUserId());
        int count = userService.updateUser(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else if (count == -1) {
            response.setRepCode(RespCode.REGISTER_USER_ACCOUNT_REPEAT_ERROR);
            response.setRepMsg(RespMsg.REGISTER_USER_ACCOUNT_REPEAT_ERROR_MSG);
        } else if (count == -2){
            response.setRepCode(RespCode.REGISTER_USER_PHONE_REPEAT_ERROR);
            response.setRepMsg(RespMsg.REGISTER_USER_PHONE_REPEAT_ERROR_MSG);
        } else {
            response.setRepCode(RespCode.REGISTER_USE_ERROR);
            response.setRepMsg(RespMsg.REGISTER_USE_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "查询用户列表")
    @RequestMapping(value = "/selectUserList", method = RequestMethod.POST)
    @ApiOperation(value = "查询用户列表", notes = "")
    public BaseResponseModel<Object> selectUserList(@RequestBody BaseRequestModelII<UserPageVo> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        Map<String, Object> map = userService.selectUserList(request.getReqData());
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepData(map);
        return response;
    }
}
