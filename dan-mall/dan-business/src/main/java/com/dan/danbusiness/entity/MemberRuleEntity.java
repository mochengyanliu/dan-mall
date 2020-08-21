package com.dan.danbusiness.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberRuleEntity {
    private Integer id;

    private Integer continueSignDay;

    private Integer continueSignPoint;

    private BigDecimal consumePerPoint;

    private BigDecimal lowOderAmenout;

    private Integer maxPointPerOrder;

    private Integer type;
}