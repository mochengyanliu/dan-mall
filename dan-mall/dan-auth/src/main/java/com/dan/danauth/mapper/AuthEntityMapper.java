package com.dan.danauth.mapper;

import com.dan.danauth.entity.AuthEntity;
import com.dan.danauth.vo.AuthPageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AuthEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthEntity record);

    int insertSelective(AuthEntity record);

    AuthEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthEntity record);

    int updateByPrimaryKey(AuthEntity record);

    List<AuthEntity> selectAuthByRoleIds(@Param("roleIds") List<Integer> roleIds);

    int updateAuthStatus(@Param("ids") List<Integer> ids, @Param("status") Integer status);

    int selectAuthListCount(@Param("authPageVO") AuthPageVO authPageVO);

    List<AuthEntity> selectAuthList(@Param("authPageVO") AuthPageVO authPageVO);

    List<AuthEntity> selectAuthTree();

    List<AuthEntity> selectAuthByParentId(@Param("roleIds") List<Integer> roleIds, @Param("parentId") Integer parentId);

}