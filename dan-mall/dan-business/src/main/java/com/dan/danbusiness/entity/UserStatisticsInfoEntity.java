package com.dan.danbusiness.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserStatisticsInfoEntity {
    private Integer id;

    private Integer userId;

    private BigDecimal consumeAmount;

    private Integer orderCount;

    private BigDecimal couponAmount;

    private Integer commentCount;

    private Integer returnOrderCount;

    private Integer loginCount;

    private Integer fansCount;

    private Integer collectProductCount;

    private Integer collectSubjectCount;

    private Integer collectTopicCount;

    private Integer collectCommentCount;
}