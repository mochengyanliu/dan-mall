package com.dan.danbusiness.service;

import com.dan.danbusiness.dto.ProductAttributeClassifyDTO;
import com.dan.danbusiness.entity.ProductAttributeEntity;
import com.dan.danbusiness.vo.AttributePageVO;

import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-10 10:41 上午
 **/

public interface ProductAttributeService {

    int insertProductAttribute(ProductAttributeEntity productAttributeEntity);

    int updateProductAttribute(ProductAttributeEntity productAttributeEntity);

    Map<String, Object> selectProductAttributeList(AttributePageVO attributePageVO);

    List<ProductAttributeEntity> selectAllProductAttribute(Integer productAttributeCategoryId);

    int deleteProductAttribute(String ids, Integer attributeCategoryId, Integer type);

    List<ProductAttributeClassifyDTO> selectAllProductAttributeClassify(Integer productAttributeCategoryId);
}
