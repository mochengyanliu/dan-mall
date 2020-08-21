package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.ProductFullReductionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductFullReductionEntityMapper {
    int insert(ProductFullReductionEntity record);

    int insertSelective(ProductFullReductionEntity record);
}