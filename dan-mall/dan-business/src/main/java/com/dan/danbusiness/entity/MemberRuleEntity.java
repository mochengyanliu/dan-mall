package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("会员规则对象")
public class MemberRuleEntity {

    @ApiModelProperty(notes = "会员规则ID")
    private Integer id;

    @ApiModelProperty(notes = "连续登陆天数")
    private Integer continueSignDay;

    @ApiModelProperty(notes = "连续登陆点数")
    private Integer continueSignPoint;

    @ApiModelProperty(notes = "消费点数")
    private BigDecimal consumePerPoint;

    @ApiModelProperty(notes = "最低订单金额")
    private BigDecimal lowOderAmenout;

    @ApiModelProperty(notes = "每个订单最大点数")
    private Integer maxPointPerOrder;

    @ApiModelProperty(notes = "类型")
    private Integer type;
}