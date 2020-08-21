package com.dan.danbusiness.service;

import com.dan.danbusiness.entity.UserEntity;
import com.dan.danbusiness.vo.UserPageVo;

import java.util.Map;

/**
 * @Author lijun
 * @Description 用户接口类
 * @Date 2020-06-23 2:42 下午
 **/

public interface UserService {

    int registerUser(UserEntity userEntity);

    Map<String, Object> selectUserList(UserPageVo userPageVo);

    int updateUser(UserEntity userEntity);
}
