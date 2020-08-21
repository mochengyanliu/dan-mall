package com.dan.danauth.mapper;

import com.dan.danauth.entity.RoleAuthEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleAuthEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleAuthEntity record);

    int insertSelective(RoleAuthEntity record);

    RoleAuthEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleAuthEntity record);

    int updateByPrimaryKey(RoleAuthEntity record);

    int checkAuthByAuthIds(List<Integer> ids);

    List<Integer> selectAllAuthIdByRoleId(Integer roleId);
}