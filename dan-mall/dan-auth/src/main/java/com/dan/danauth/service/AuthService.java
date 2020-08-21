package com.dan.danauth.service;

import com.dan.danauth.dto.AuthEntityDTO;
import com.dan.danauth.entity.AuthEntity;
import com.dan.danauth.vo.AuthPageVO;

import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description 权限接口类
 * @Date 2020-06-16 1:15 下午
 **/

public interface AuthService {

    int insertAuth(AuthEntity authEntity);

    int updateAuth(AuthEntity authEntity);

    int updateAuthStatus(List<Integer> ids, Integer status);

    Map<String, Object> selectAuthList(AuthPageVO authPageVO);

    List<AuthEntityDTO> selectAuthTree();

    List<AuthEntity> selectAllAuth();
}
