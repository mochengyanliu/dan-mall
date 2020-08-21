package com.dan.danbusiness.service;

import com.dan.danbusiness.dto.ProductCategoryDTO;
import com.dan.danbusiness.entity.ProductCategoryEntity;
import com.dan.danbusiness.vo.ProductCategoryPageVO;

import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-06-23 3:10 下午
 **/

public interface ProductCategoryService {

    int addProductCategory(ProductCategoryEntity productCategoryEntity);

    int updateProductCategory(ProductCategoryEntity productCategoryEntity);

    Map<String, Object> selectProductCategoryList(ProductCategoryPageVO productCategoryPageVO);

    List<ProductCategoryDTO> selectProductCategoryTree();

    List<ProductCategoryEntity> selectAllProductCategory();
}
