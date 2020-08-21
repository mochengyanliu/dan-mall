package com.dan.danbusiness.service.impl;

import com.dan.danbusiness.dto.ProductAttributeClassifyDTO;
import com.dan.danbusiness.entity.ProductAttributeEntity;
import com.dan.danbusiness.mapper.ProductAttributeCategoryEntityMapper;
import com.dan.danbusiness.mapper.ProductAttributeEntityMapper;
import com.dan.danbusiness.service.ProductAttributeService;
import com.dan.danbusiness.vo.AttributePageVO;
import com.dan.dancommon.util.PageUtil;
import com.dan.dancommon.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-10 10:42 上午
 **/

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

    @Autowired
    ProductAttributeEntityMapper productAttributeEntityMapper;

    @Autowired
    ProductAttributeCategoryEntityMapper productAttributeCategoryEntityMapper;

    @Override
    public int insertProductAttribute(ProductAttributeEntity productAttributeEntity) {
        int count = productAttributeEntityMapper.checkproductAttributeName(productAttributeEntity.getName(), productAttributeEntity.getProductAttributeCategoryId(), null);
        if (count > 0) {
            return -1;
        }
        productAttributeCategoryEntityMapper.updateAttributeCountOrParamCountByType(productAttributeEntity.getType(), productAttributeEntity.getProductAttributeCategoryId(), 1);
        return productAttributeEntityMapper.insertSelective(productAttributeEntity);
    }

    @Override
    public int updateProductAttribute(ProductAttributeEntity productAttributeEntity) {
        int count = productAttributeEntityMapper.checkproductAttributeName(productAttributeEntity.getName(), productAttributeEntity.getProductAttributeCategoryId(), productAttributeEntity.getId());
        if (count > 0) {
            return -1;
        }
        return productAttributeEntityMapper.updateByPrimaryKey(productAttributeEntity);
    }

    @Override
    public Map<String, Object> selectProductAttributeList(AttributePageVO attributePageVO) {
        Map<String, Object> map = new HashMap<>();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNumber(attributePageVO.getPageNumber());
        pageUtil.setTotalNumber(productAttributeEntityMapper.selectProductAttributeListCount(attributePageVO));
        pageUtil.setCurrentPage(attributePageVO.getCurrentPage());
        attributePageVO.setDbIndex(pageUtil.getDbIndex());
        attributePageVO.setDbNumber(pageUtil.getDbNumber());
        List<ProductAttributeEntity> productAttributeEntities = productAttributeEntityMapper.selectProductAttributeList(attributePageVO);
        map.put("pageUtil", pageUtil);
        map.put("productAttributeEntities", productAttributeEntities);
        return map;
    }

    @Override
    public List<ProductAttributeEntity> selectAllProductAttribute(Integer productAttributeCategoryId) {
        return productAttributeEntityMapper.selectAllProductAttribute(productAttributeCategoryId);
    }

    @Override
    public int deleteProductAttribute(String ids, Integer attributeCategoryId, Integer type) {
        if (StringUtil.isEmpty(ids, true)) {
            return -1;
        }
        List<String> list = Arrays.asList(ids.split(","));
        productAttributeCategoryEntityMapper.updateAttributeCountOrParamCountByType(type, attributeCategoryId, -list.size());
        return productAttributeEntityMapper.deleteByPrimaryKeys(list);
    }

    @Override
    public List<ProductAttributeClassifyDTO> selectAllProductAttributeClassify(Integer productAttributeCategoryId) {
        List<ProductAttributeClassifyDTO> productAttributeClassifyDTOS = new ArrayList<>();
        // 查询商品规格
        ProductAttributeClassifyDTO productAttributeClassifyDTO = new ProductAttributeClassifyDTO();
        productAttributeClassifyDTO.setProductAttributeEntities(productAttributeEntityMapper.selectAllProductAttributeClassify(productAttributeCategoryId, 0));
        if (productAttributeClassifyDTO.getProductAttributeEntities().size()>0){
            productAttributeClassifyDTO.setType(0);
        }
        productAttributeClassifyDTOS.add(productAttributeClassifyDTO);
        // 查询商品参数
        productAttributeClassifyDTO = new ProductAttributeClassifyDTO();
        productAttributeClassifyDTO.setType(1);
        productAttributeClassifyDTO.setProductAttributeEntities(productAttributeEntityMapper.selectAllProductAttributeClassify(productAttributeCategoryId, 1));
        if (productAttributeClassifyDTO.getProductAttributeEntities().size()>0){
            productAttributeClassifyDTO.setType(1);
        }
        productAttributeClassifyDTOS.add(productAttributeClassifyDTO);
        return productAttributeClassifyDTOS;
    }
}
