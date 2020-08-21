package com.dan.danbusiness.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SpecialPromotionEntity {
    private Integer id;

    private Integer productId;

    private Date beginTime;

    private Date endTime;

    private BigDecimal price;
}