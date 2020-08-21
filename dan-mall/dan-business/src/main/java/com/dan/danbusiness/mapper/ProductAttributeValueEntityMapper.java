package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.ProductAttributeValueEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductAttributeValueEntityMapper {
    int insert(ProductAttributeValueEntity record);

    int insertSelective(ProductAttributeValueEntity record);
}