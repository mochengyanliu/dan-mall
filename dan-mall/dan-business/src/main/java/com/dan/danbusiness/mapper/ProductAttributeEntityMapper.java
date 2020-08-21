package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.ProductAttributeEntity;
import com.dan.danbusiness.vo.AttributePageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductAttributeEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductAttributeEntity record);

    int insertSelective(ProductAttributeEntity record);

    ProductAttributeEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductAttributeEntity record);

    int updateByPrimaryKey(ProductAttributeEntity record);

    int checkproductAttributeName(@Param("name") String name, @Param("productAttributeCategoryId") Integer productAttributeCategoryId, @Param("id") Integer id);

    int selectProductAttributeListCount(@Param("attributePageVO") AttributePageVO attributePageVO);

    List<ProductAttributeEntity> selectProductAttributeList(@Param("attributePageVO") AttributePageVO attributePageVO);

    List<ProductAttributeEntity> selectAllProductAttribute(Integer productAttributeCategoryId);

    int deleteByPrimaryKeys(@Param("ids") List<String> ids);

    List<ProductAttributeEntity> selectAllProductAttributeClassify(@Param("productAttributeCategoryId") Integer productAttributeCategoryId, @Param("type") Integer type);
}