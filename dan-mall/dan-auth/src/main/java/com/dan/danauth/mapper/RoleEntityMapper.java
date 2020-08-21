package com.dan.danauth.mapper;

import com.dan.danauth.entity.RoleEntity;
import com.dan.danauth.vo.RolePageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);

    List<RoleEntity> selectRoleByUserId(Integer userId);

    int checkNameByNameAndStatus(@Param("name") String name, @Param("id") Integer id);

    int deleteRoleAuthByRoleId(Integer roleId);

    int updateRoleStatus(@Param("ids") List<Integer> ids, @Param("stauts") Integer status);

    List<Integer> selectRoleIdsByUserId(Integer userId);

    List<RoleEntity> selectAllRole();

    RoleEntity selectRoleByDictValue(Integer dictValue);

    Integer selectRoleListCount(@Param("rolePageVO") RolePageVO rolePageVO);

    List<RoleEntity> selectRoleList(@Param("rolePageVO") RolePageVO rolePageVO);
}