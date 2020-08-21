package com.dan.danauth.mapper;

import com.dan.danauth.entity.OperLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OperLogEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperLogEntity record);

    int insertSelective(OperLogEntity record);

    OperLogEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OperLogEntity record);

    int updateByPrimaryKey(OperLogEntity record);
}