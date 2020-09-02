package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.SkuStockEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    int insertArraySkuStock(@Param("skuStockEntityList") List<SkuStockEntity> skuStockEntityList);

    int deleteSkuStockByProductId(Integer productId);
}