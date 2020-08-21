package com.dan.danauth.service.impl;

import com.dan.danauth.entity.AuthEntity;
import com.dan.danauth.entity.RoleAuthEntity;
import com.dan.danauth.entity.RoleEntity;
import com.dan.danauth.mapper.RoleAuthEntityMapper;
import com.dan.danauth.mapper.RoleEntityMapper;
import com.dan.danauth.mapper.UserRoleEntityMapper;
import com.dan.danauth.service.RoleService;
import com.dan.danauth.vo.RolePageVO;
import com.dan.dancommon.base.BaseResponseModel;
import com.dan.dancommon.constants.RespCode;
import com.dan.dancommon.constants.RespMsg;
import com.dan.dancommon.util.PageUtil;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-06-16 5:10 下午
 **/

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleEntityMapper roleEntityMapper;

    @Autowired
    private RoleAuthEntityMapper roleAuthEntityMapper;

    @Autowired
    private UserRoleEntityMapper userRoleEntityMapper;

    @Override
    public BaseResponseModel<Object> insertRole(RoleEntity roleEntity) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = roleEntityMapper.checkNameByNameAndStatus(roleEntity.getName(), null);
        if (count > 0) {
            response.setRepCode(RespCode.INSERT_ROLE_REPEAT_ERROR);
            response.setRepMsg(RespMsg.INSERT_ROLE_REPEAT_ERROR_MSG);
            return response;
        }
        count = roleEntityMapper.insertSelective(roleEntity);
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
            return response;
        } else {
            response.setRepCode(RespCode.INSERT_ROLE_ERROR);
            response.setRepMsg(RespMsg.INSERT_ROLE_ERROR_MSG);
            return response;
        }
    }

    @Override
    public BaseResponseModel<Object> updateRole(RoleEntity roleEntity) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = roleEntityMapper.checkNameByNameAndStatus(roleEntity.getName(), roleEntity.getId());
        if (count > 0) {
            response.setRepCode(RespCode.UPDATA_ROLE_REPEAT_ERROR);
            response.setRepMsg(RespMsg.UPDATA_ROLE_REPEAT_ERROR_MSG);
            return response;
        }
        count = roleEntityMapper.updateByPrimaryKeySelective(roleEntity);
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
            return response;
        } else {
            response.setRepCode(RespCode.UPDATE_ROLE_ERROR);
            response.setRepMsg(RespMsg.UPDATE_ROLE_ERROR_MSG);
            return response;
        }
    }

    @Override
    public int insertRoleAndAuth(Integer roleId, List<Integer> authIds) {
        // 先删除角色绑定的权限
        int count = roleEntityMapper.deleteRoleAuthByRoleId(roleId);
        // 角色绑定权限
        for (Integer authId : authIds) {
            RoleAuthEntity roleAuthEntity = new RoleAuthEntity();
            roleAuthEntity.setAuthId(authId);
            roleAuthEntity.setRoleId(roleId);
            count = roleAuthEntityMapper.insert(roleAuthEntity);
        }
        return count;
    }

    @Override
    public int updateRoleStatus(List<Integer> ids, Integer status) {
        Integer count = userRoleEntityMapper.checkRoleByRoleIds(ids);
        if (count>0){
            return -1;
        }
        return roleEntityMapper.updateRoleStatus(ids, status);
    }

    @Override
    public List<Integer> selectRoleIdsByUserId(Integer userId) {
        return roleEntityMapper.selectRoleIdsByUserId(userId);
    }

    @Override
    public List<RoleEntity> selectAllRole() {
        return roleEntityMapper.selectAllRole();
    }

    @Override
    public Map<String, Object> selectRoleList(RolePageVO rolePageVO) {
        Map<String, Object> map = new HashMap<>();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNumber(rolePageVO.getPageNumber());
        pageUtil.setTotalNumber(roleEntityMapper.selectRoleListCount(rolePageVO));
        pageUtil.setCurrentPage(rolePageVO.getCurrentPage());
        rolePageVO.setDbIndex(pageUtil.getDbIndex());
        rolePageVO.setDbNumber(pageUtil.getDbNumber());
        List<RoleEntity> roleEntities = roleEntityMapper.selectRoleList(rolePageVO);
        map.put("pageUtil", pageUtil);
        map.put("roleEntities", roleEntities);
        return map;
    }

    @Override
    public List<Integer> selectAllAuthIdByRoleId(Integer roleId) {
        return roleAuthEntityMapper.selectAllAuthIdByRoleId(roleId);
    }
}
