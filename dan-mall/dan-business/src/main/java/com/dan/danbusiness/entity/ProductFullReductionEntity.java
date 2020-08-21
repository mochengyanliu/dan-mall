package com.dan.danbusiness.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductFullReductionEntity {
    private Integer id;

    private Integer productId;

    private BigDecimal fullPrice;

    private BigDecimal reducePrice;
}