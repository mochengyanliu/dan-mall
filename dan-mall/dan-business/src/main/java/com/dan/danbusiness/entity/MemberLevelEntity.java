package com.dan.danbusiness.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MemberLevelEntity {
    private Integer id;

    private String name;

    private Integer growthPoint;

    private Integer status;

    private Integer sort;

    private BigDecimal freeFreightPoint;

    private Integer commentGrowthPoint;

    private Integer privilegeFreeFreight;

    private Integer privilegeSignIn;

    private Integer privilegeComment;

    private Integer privilegePromotion;

    private Integer privilegeMemberPrice;

    private Integer privilegeBirthday;
}