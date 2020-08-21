package com.dan.danauth.service.impl;

import com.dan.danauth.dto.AuthEntityDTO;
import com.dan.danauth.entity.AuthEntity;
import com.dan.danauth.mapper.AuthEntityMapper;
import com.dan.danauth.mapper.RoleAuthEntityMapper;
import com.dan.danauth.service.AuthService;
import com.dan.danauth.vo.AuthPageVO;
import com.dan.dancommon.enums.Constant;
import com.dan.dancommon.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author lijun
 * @Description 权限接口实现类
 * @Date 2020-06-16 1:16 下午
 **/

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthEntityMapper authEntityMapper;

    @Autowired
    RoleAuthEntityMapper roleAuthEntityMapper;

    @Override
    public int insertAuth(AuthEntity authEntity) {
        authEntity.setSysId(Integer.parseInt(Constant.SYS_ID.getValue()));
        authEntity.setCreateTime(new Date());
        return authEntityMapper.insertSelective(authEntity);
    }

    @Override
    public int updateAuth(AuthEntity authEntity) {
        authEntity.setUpdateTime(new Date());
        return authEntityMapper.updateByPrimaryKeySelective(authEntity);
    }

    @Override
    public int updateAuthStatus(List<Integer> ids, Integer status) {
        int count = roleAuthEntityMapper.checkAuthByAuthIds(ids);
        if (count>0){
            return -1;
        }
        return authEntityMapper.updateAuthStatus(ids, status);
    }

    @Override
    public Map<String, Object> selectAuthList(AuthPageVO authPageVO) {
        Map<String, Object> map = new HashMap<>();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNumber(authPageVO.getPageNumber());
        pageUtil.setTotalNumber(authEntityMapper.selectAuthListCount(authPageVO));
        pageUtil.setCurrentPage(authPageVO.getCurrentPage());
        authPageVO.setDbIndex(pageUtil.getDbIndex());
        authPageVO.setDbNumber(pageUtil.getDbNumber());
        List<AuthEntity> authEntities = authEntityMapper.selectAuthList(authPageVO);
        map.put("pageUtil", pageUtil);
        map.put("authEntities", authEntities);
        return map;
    }

    @Override
    public List<AuthEntityDTO> selectAuthTree() {
        List<AuthEntity> authEntities = authEntityMapper.selectAuthTree();
        return getAuth(0, authEntities);
    }

    @Override
    public List<AuthEntity> selectAllAuth() {
        return authEntityMapper.selectAuthTree();
    }

    /**
     * 递归获取权限
     *
     * @param authId
     * @param list
     * @return
     */
    public static List<AuthEntityDTO> getAuth(Integer authId, List<AuthEntity> list) {
        List<AuthEntityDTO> authEntities = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (authId.equals(list.get(i).getParentId())) {
                AuthEntityDTO authEntityDTO = new AuthEntityDTO();
                authEntityDTO.setId(list.get(i).getId());
                authEntityDTO.setIcon(list.get(i).getClazz());
                authEntityDTO.setTitle(list.get(i).getName());
                authEntityDTO.setName(list.get(i).getTarget());
                authEntityDTO.setChildren(getAuth(list.get(i).getId(), list));
                authEntities.add(authEntityDTO);
            }
        }
        return authEntities;
    }
}
