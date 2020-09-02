package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.ProductFullReductionEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductFullReductionEntityMapper {
    int insert(ProductFullReductionEntity record);

    int insertSelective(ProductFullReductionEntity record);

    int insertArrayProductFullReduction(@Param("productFullReductionEntityList") List<ProductFullReductionEntity> productFullReductionEntityList);

    int deleteProductFullReductionByProductId(Integer productId);
}