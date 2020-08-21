package com.dan.danbusiness.service.impl;

import com.dan.danbusiness.entity.ProductEntity;
import com.dan.danbusiness.mapper.ProductEntityMapper;
import com.dan.danbusiness.service.ProductService;
import com.dan.danbusiness.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-17 4:50 下午
 **/

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductEntityMapper productEntityMapper;

    @Override
    public int insertProduct(ProductVO productVO) {
        ProductEntity productEntity = new ProductEntity();
        return productEntityMapper.insertSelective(productEntity);
    }
}
