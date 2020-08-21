package com.dan.danbusiness.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberPriceEntity {
    private Integer id;

    private Integer productId;

    private Integer memberLevelId;

    private BigDecimal memberPrice;

    private String memberLevelName;
}