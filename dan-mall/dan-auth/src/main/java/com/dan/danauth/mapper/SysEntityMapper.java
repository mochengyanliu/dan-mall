package com.dan.danauth.mapper;

import com.dan.danauth.entity.SysEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysEntity record);

    int insertSelective(SysEntity record);

    SysEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysEntity record);

    int updateByPrimaryKey(SysEntity record);
}