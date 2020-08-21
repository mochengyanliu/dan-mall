package com.dan.danbusiness.entity;

import lombok.Data;

@Data
public class ProductAttributeValueEntity {
    private Integer id;

    private Integer productId;

    private Integer productAttributeId;

    private String inputList;

    private Integer pic;
}