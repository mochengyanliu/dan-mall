package com.dan.danbusiness.service;

import com.dan.danbusiness.entity.ProductAttributeCategoryEntity;
import com.dan.danbusiness.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-07 3:53 下午
 **/

public interface ProductAttributeCategoryService {

    int insertProductAttributeCategory(ProductAttributeCategoryEntity productAttributeCategoryEntity);

    int updateProductAttributeCategory(ProductAttributeCategoryEntity productAttributeCategoryEntity);

    Map<String, Object> selectProductAttributeCategoryList(PageVO pageVO);

    List<ProductAttributeCategoryEntity> selectAllProductAttributeCategory();

    int deleteProductAttributeCategory(String ids);
}
