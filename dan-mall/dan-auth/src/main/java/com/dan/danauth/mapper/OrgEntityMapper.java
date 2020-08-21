package com.dan.danauth.mapper;

import com.dan.danauth.entity.OrgEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrgEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgEntity record);

    int insertSelective(OrgEntity record);

    OrgEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgEntity record);

    int updateByPrimaryKey(OrgEntity record);
}