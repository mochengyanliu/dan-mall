package com.dan.danauth.service;

import com.dan.danauth.entity.RoleEntity;
import com.dan.danauth.vo.RolePageVO;
import com.dan.dancommon.base.BaseResponseModel;

import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-06-16 5:09 下午
 **/

public interface RoleService {
    BaseResponseModel<Object> insertRole(RoleEntity roleEntity);

    BaseResponseModel<Object> updateRole(RoleEntity roleEntity);

    int insertRoleAndAuth(Integer roleId, List<Integer> authIds);

    int updateRoleStatus(List<Integer> ids, Integer status);

    List<Integer> selectRoleIdsByUserId(Integer userId);

    List<RoleEntity> selectAllRole();

    Map<String, Object> selectRoleList(RolePageVO rolePageVO);

    List<Integer> selectAllAuthIdByRoleId(Integer roleId);
}
