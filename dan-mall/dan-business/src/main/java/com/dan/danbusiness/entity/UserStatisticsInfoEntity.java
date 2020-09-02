package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("用户统计对象")
public class UserStatisticsInfoEntity {

    @ApiModelProperty(notes = "用户统计ID")
    private Integer id;

    @ApiModelProperty(notes = "用户ID")
    private Integer userId;

    @ApiModelProperty(notes = "消费总额")
    private BigDecimal consumeAmount;

    @ApiModelProperty(notes = "订单数")
    private Integer orderCount;

    @ApiModelProperty(notes = "优惠总额")
    private BigDecimal couponAmount;

    @ApiModelProperty(notes = "评价次数")
    private Integer commentCount;

    @ApiModelProperty(notes = "订单取消数")
    private Integer returnOrderCount;

    @ApiModelProperty(notes = "登陆次数")
    private Integer loginCount;

    @ApiModelProperty(notes = "粉丝数")
    private Integer fansCount;

    @ApiModelProperty(notes = "收藏产品数")
    private Integer collectProductCount;

    @ApiModelProperty(notes = "收藏主题数")
    private Integer collectSubjectCount;

    @ApiModelProperty(notes = "收藏话题数")
    private Integer collectTopicCount;

    @ApiModelProperty(notes = "收藏评价数")
    private Integer collectCommentCount;
}