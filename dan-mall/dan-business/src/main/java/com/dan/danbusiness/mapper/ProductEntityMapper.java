package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductEntity record);

    int insertSelective(ProductEntity record);

    ProductEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductEntity record);

    int updateByPrimaryKeyWithBLOBs(ProductEntity record);

    int updateByPrimaryKey(ProductEntity record);
}