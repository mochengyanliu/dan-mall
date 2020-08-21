package com.dan.danbusiness.service.impl;

import com.dan.danbusiness.entity.ProductAttributeCategoryEntity;
import com.dan.danbusiness.mapper.ProductAttributeCategoryEntityMapper;
import com.dan.danbusiness.service.ProductAttributeCategoryService;
import com.dan.danbusiness.vo.PageVO;
import com.dan.dancommon.util.PageUtil;
import com.dan.dancommon.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-07 3:55 下午
 **/

@Service
public class ProductAttributeCategoryServiceImpl implements ProductAttributeCategoryService {

    @Autowired
    ProductAttributeCategoryEntityMapper productAttributeCategoryEntityMapper;

    @Override
    public int insertProductAttributeCategory(ProductAttributeCategoryEntity productAttributeCategoryEntity) {
        int count = productAttributeCategoryEntityMapper.checkproductAttributeCategoryName(productAttributeCategoryEntity.getName(), null);
        if (count>0){
            return -1;
        }
        return productAttributeCategoryEntityMapper.insertSelective(productAttributeCategoryEntity);
    }

    @Override
    public int updateProductAttributeCategory(ProductAttributeCategoryEntity productAttributeCategoryEntity) {
        int count = productAttributeCategoryEntityMapper.checkproductAttributeCategoryName(productAttributeCategoryEntity.getName(), productAttributeCategoryEntity.getId());
        if (count>0){
            return -1;
        }
        return productAttributeCategoryEntityMapper.updateByPrimaryKeySelective(productAttributeCategoryEntity);
    }

    @Override
    public Map<String, Object> selectProductAttributeCategoryList(PageVO pageVO) {
        Map<String, Object> map = new HashMap<>();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNumber(pageVO.getPageNumber());
        pageUtil.setTotalNumber(productAttributeCategoryEntityMapper.selectProductAttributeCategoryListCount());
        pageUtil.setCurrentPage(pageVO.getCurrentPage());
        pageVO.setDbIndex(pageUtil.getDbIndex());
        pageVO.setDbNumber(pageUtil.getDbNumber());
        List<ProductAttributeCategoryEntity> productAttributeCategoryEntities = productAttributeCategoryEntityMapper.selectProductAttributeCategoryList(pageVO);
        map.put("pageUtil", pageUtil);
        map.put("productAttributeCategoryEntities", productAttributeCategoryEntities);
        return map;
    }

    @Override
    public List<ProductAttributeCategoryEntity> selectAllProductAttributeCategory() {
        return productAttributeCategoryEntityMapper.selectAllProductAttributeCategory();
    }

    @Override
    public int deleteProductAttributeCategory(String ids) {
        if (StringUtil.isEmpty(ids, true)) {
            return -1;
        }
        List<String> list = Arrays.asList(ids.split(","));
        return productAttributeCategoryEntityMapper.deleteByPrimaryKeys(list);
    }
}
