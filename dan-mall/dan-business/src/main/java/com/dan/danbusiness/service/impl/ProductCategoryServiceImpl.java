package com.dan.danbusiness.service.impl;

import com.dan.danbusiness.dto.ProductCategoryDTO;
import com.dan.danbusiness.entity.ProductCategoryEntity;
import com.dan.danbusiness.mapper.ProductCategoryEntityMapper;
import com.dan.danbusiness.service.ProductCategoryService;
import com.dan.danbusiness.vo.ProductCategoryPageVO;
import com.dan.dancommon.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-06-23 3:10 下午
 **/

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryEntityMapper productCategoryEntityMapper;

    @Override
    public int addProductCategory(ProductCategoryEntity productCategoryEntity) {
        // 检查产品分类名字是否重复
        int count = productCategoryEntityMapper.checkProductCategoryName(productCategoryEntity.getName(), null);
        if (count>0){
            return -1;
        }
        productCategoryEntity.setCreateTime(new Date());
        return productCategoryEntityMapper.insertSelective(productCategoryEntity);
    }

    @Override
    public int updateProductCategory(ProductCategoryEntity productCategoryEntity) {
        // 检查产品分类名字是否重复
        int count = productCategoryEntityMapper.checkProductCategoryName(productCategoryEntity.getName(), productCategoryEntity.getId());
        if (count>0){
            return -1;
        }
        productCategoryEntity.setUpdateTime(new Date());
        return productCategoryEntityMapper.updateByPrimaryKey(productCategoryEntity);
    }

    @Override
    public Map<String, Object> selectProductCategoryList(ProductCategoryPageVO productCategoryPageVO) {
        Map<String, Object> map = new HashMap<>();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNumber(productCategoryPageVO.getPageNumber());
        pageUtil.setTotalNumber(productCategoryEntityMapper.selectProductCategoryListCount(productCategoryPageVO));
        pageUtil.setCurrentPage(productCategoryPageVO.getCurrentPage());
        productCategoryPageVO.setDbIndex(pageUtil.getDbIndex());
        productCategoryPageVO.setDbNumber(pageUtil.getDbNumber());
        List<ProductCategoryEntity> productCategoryEntities = productCategoryEntityMapper.selectProductCategoryList(productCategoryPageVO);
        map.put("pageUtil", pageUtil);
        map.put("productCategoryEntities", productCategoryEntities);
        return map;
    }

    @Override
    public List<ProductCategoryDTO> selectProductCategoryTree() {
        List<ProductCategoryEntity> authEntities = productCategoryEntityMapper.selectProductCategoryTree();
        return getProductCategory(0, authEntities);
    }

    @Override
    public List<ProductCategoryEntity> selectAllProductCategory() {
        return productCategoryEntityMapper.selectProductCategoryTree();
    }

    /**
     * 递归获取商品分类
     *
     * @param productCategoryId
     * @param list
     * @return
     */
    public static List<ProductCategoryDTO> getProductCategory(Integer productCategoryId, List<ProductCategoryEntity> list) {
        List<ProductCategoryDTO> productCategoryDTOS = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (productCategoryId.equals(list.get(i).getParentId())) {
                ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
                productCategoryDTO.setId(list.get(i).getId());
                productCategoryDTO.setName(list.get(i).getName());
                productCategoryDTO.setChildren(getProductCategory(list.get(i).getId(), list));
                productCategoryDTOS.add(productCategoryDTO);
            }
        }
        return productCategoryDTOS;
    }
}
