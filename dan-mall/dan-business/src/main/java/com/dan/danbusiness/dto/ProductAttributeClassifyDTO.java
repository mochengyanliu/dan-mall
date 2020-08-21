package com.dan.danbusiness.dto;

import com.dan.danbusiness.entity.ProductAttributeEntity;
import lombok.Data;

import java.util.List;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-12 10:37 上午
 **/

@Data
public class ProductAttributeClassifyDTO {
    private Integer type;

    List<ProductAttributeEntity> productAttributeEntities;
}
