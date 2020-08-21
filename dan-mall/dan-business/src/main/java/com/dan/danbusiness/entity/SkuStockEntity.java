package com.dan.danbusiness.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SkuStockEntity {
    private Integer id;

    private Integer productId;

    private String skuCode;

    private BigDecimal price;

    private Integer stock;

    private Integer lowStock;

    private String sp1;

    private String sp2;

    private String sp3;

    private String pic;

    private Integer sale;
}