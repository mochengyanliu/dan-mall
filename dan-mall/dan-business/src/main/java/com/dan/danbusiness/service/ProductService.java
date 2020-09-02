package com.dan.danbusiness.service;

import com.dan.danbusiness.vo.ProductPageVO;
import com.dan.danbusiness.vo.ProductVO;

import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-17 4:50 下午
 **/

public interface ProductService {

    int insertProduct(ProductVO productVO);

    int updateProduct(ProductVO productVO);

    Map<String, Object> selectProductList(ProductPageVO productPageVO);

    int deleteProduct(String ids);
}
