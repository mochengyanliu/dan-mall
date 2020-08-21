package com.dan.danauth.service;

import com.dan.danauth.entity.UserEntity;
import com.dan.dancommon.base.BaseResponseModel;

/**
 * @Author lijun
 * @Description 用户接口类
 * @Date 2020-06-16 9:38 上午
 **/

public interface UserService {
    int insertUser(UserEntity userEntity);

    BaseResponseModel<Object> updatePassword(Integer userId, String oldPassword, String newPassword, String repPassword);

    int updateUser(UserEntity userEntity);
}
