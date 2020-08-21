package com.dan.danauth.controller;

import com.dan.danauth.entity.UserEntity;
import com.dan.danauth.service.UserService;
import com.dan.dancommon.base.BaseRequestModel;
import com.dan.dancommon.base.BaseResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lijun
 * @Description 用户控制器类
 * @Date 2020-06-16 9:38 上午
 **/

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public int insertUser(@RequestBody UserEntity userEntity) {
        log.info("------------------------------权限系统新增用户------------------------------");
        return userService.insertUser(userEntity);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public int updateUser(@RequestBody UserEntity userEntity) {
        log.info("------------------------------权限系统修改用户------------------------------");
        return userService.updateUser(userEntity);
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public BaseResponseModel<Object> updatePassword(@RequestBody BaseRequestModel request) {
        log.info("------------------------------修改密码开始------------------------------");
        String oldPassword = request.getReqData().getString("oldPassword");
        String newPassword = request.getReqData().getString("newPassword");
        String repPassword = request.getReqData().getString("repPassword");
        BaseResponseModel<Object> response = userService.updatePassword(request.getUserId(), oldPassword, newPassword, repPassword);
        log.info("------------------------------修改密码结束------------------------------");
        return response;
    }
}
