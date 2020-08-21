package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.SkuStockEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SkuStockEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SkuStockEntity record);

    int insertSelective(SkuStockEntity record);

    SkuStockEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkuStockEntity record);

    int updateByPrimaryKey(SkuStockEntity record);
}