package com.dan.danauth.service.impl;

import com.dan.danauth.entity.UserEntity;
import com.dan.danauth.entity.UserRoleEntity;
import com.dan.danauth.mapper.UserEntityMapper;
import com.dan.danauth.mapper.UserRoleEntityMapper;
import com.dan.danauth.service.UserService;
import com.dan.dancommon.base.BaseResponseModel;
import com.dan.dancommon.constants.RespCode;
import com.dan.dancommon.constants.RespMsg;
import com.dan.dancommon.enums.Constant;
import com.dan.dancommon.util.MD5Util;
import com.dan.dancommon.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author lijun
 * @Description 用户接口实现类
 * @Date 2020-06-16 9:38 上午
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityMapper userEntityMapper;

    @Autowired
    UserRoleEntityMapper userRoleEntityMapper;

    @Override
    public int insertUser(UserEntity userEntity) {
        // 新增用户表
        userEntity.setCreateTime(new Date());
        userEntity.setPassword(MD5Util.getMD5Code(Constant.PARENT_ID.getValue() + MD5Util.getMD5Code(Constant.PASSWORD_ID.getValue())));
        int count = userEntityMapper.insertSelective(userEntity);
        if (count > 0) {
            // 新增权限表
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setUserId(userEntity.getId());
            userRoleEntity.setRoleId(userEntity.getRoleId());
            userRoleEntity.setCreateUserId(userEntity.getCreateUserId());
            userRoleEntity.setCreateTime(new Date());
            userRoleEntityMapper.insertSelective(userRoleEntity);
            return userEntity.getId();
        }
        return count;
    }

    @Override
    public BaseResponseModel<Object> updatePassword(Integer userId, String oldPassword, String newPassword, String repPassword) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        String password = userEntityMapper.selectPasswordByUserId(userId);
        // 验证老密码是否正确
        if (StringUtil.isEmpty(oldPassword, true) || password == null || !password.equals(MD5Util.getMD5Code(Constant.PARENT_ID.getValue() + oldPassword))) {
            response.setRepCode(RespCode.OLD_PASSWORD_ERROR);
            response.setRepMsg(RespMsg.OLD_PASSWORD_ERROR_MSG);
            return response;
        }
        // 验证新密码是否正确
        if (StringUtil.isEmpty(newPassword, true) || StringUtil.isEmpty(repPassword, true)) {
            response.setRepCode(RespCode.NEW_PASSWORD_NOT_ERROR);
            response.setRepMsg(RespMsg.NEW_PASSWORD_NOT_ERROR_MSG);
            return response;
        }
        // 验证新密码和重复密码是否一致
        if (!newPassword.equals(repPassword)) {
            response.setRepCode(RespCode.NEW_PASSWORD_ERROR);
            response.setRepMsg(RespMsg.NEW_PASSWORD_ERROR_MSG);
            return response;
        }

        // 业务系统修改密码
        int count = userEntityMapper.updatePasswordByUserId(userId, MD5Util.getMD5Code(Constant.PARENT_ID.getValue() + newPassword));
        if (count == 0) {
            response.setRepCode(RespCode.UPDATE_PASSWORD_ERROR);
            response.setRepMsg(RespMsg.UPDATE_PASSWORD_ERROR_MSG);
            return response;
        }
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        return response;
    }

    @Override
    public int updateUser(UserEntity userEntity) {
        // 新增用户表
        userEntity.setUpdateTime(new Date());
        int count = userEntityMapper.updateByPrimaryKeySelective(userEntity);
        if (count > 0) {
            // 删除原来角色
            userRoleEntityMapper.deleteByUserId(userEntity.getId());
            // 新增权限表
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setUserId(userEntity.getId());
            userRoleEntity.setRoleId(userEntity.getRoleId());
            userRoleEntity.setCreateUserId(userEntity.getCreateUserId());
            userRoleEntity.setCreateTime(new Date());
            userRoleEntityMapper.insertSelective(userRoleEntity);
            return userEntity.getId();
        }
        return count;
    }
}
