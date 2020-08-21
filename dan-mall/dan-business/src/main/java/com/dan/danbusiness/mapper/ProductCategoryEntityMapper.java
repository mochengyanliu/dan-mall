package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.ProductCategoryEntity;
import com.dan.danbusiness.vo.ProductCategoryPageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ProductCategoryEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductCategoryEntity record);

    int insertSelective(ProductCategoryEntity record);

    ProductCategoryEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductCategoryEntity record);

    int updateByPrimaryKeyWithBLOBs(ProductCategoryEntity record);

    int updateByPrimaryKey(ProductCategoryEntity record);

    Integer checkProductCategoryName(@Param("name") String name, @Param("id") Integer id);

    Integer selectProductCategoryListCount(@Param("productCategoryPageVO") ProductCategoryPageVO productCategoryPageVO);

    List<ProductCategoryEntity> selectProductCategoryList(@Param("productCategoryPageVO") ProductCategoryPageVO productCategoryPageVO);

    List<ProductCategoryEntity> selectProductCategoryTree();
}