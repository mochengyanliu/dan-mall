package com.dan.danbusiness.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductLadderEntity {
    private Integer id;

    private Integer productId;

    private Integer count;

    private BigDecimal discount;

    private BigDecimal price;
}