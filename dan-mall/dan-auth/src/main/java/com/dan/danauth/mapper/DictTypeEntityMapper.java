package com.dan.danauth.mapper;

import com.dan.danauth.entity.DictTypeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DictTypeEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictTypeEntity record);

    int insertSelective(DictTypeEntity record);

    DictTypeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictTypeEntity record);

    int updateByPrimaryKey(DictTypeEntity record);
}