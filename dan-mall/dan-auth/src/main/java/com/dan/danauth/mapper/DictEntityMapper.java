package com.dan.danauth.mapper;

import com.dan.danauth.entity.DictEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DictEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DictEntity record);

    int insertSelective(DictEntity record);

    DictEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DictEntity record);

    int updateByPrimaryKey(DictEntity record);

    List<DictEntity> selectDictListByTypeId(Integer type);
}