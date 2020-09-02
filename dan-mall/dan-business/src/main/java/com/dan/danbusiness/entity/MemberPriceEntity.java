package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("会员价格对象")
public class MemberPriceEntity {

    @ApiModelProperty(notes = "会员价格ID")
    private Integer id;

    @ApiModelProperty(notes = "商品ID")
    private Integer productId;

    @ApiModelProperty(notes = "会员等级ID")
    private Integer memberLevelId;

    @ApiModelProperty(notes = "会员价格")
    private BigDecimal memberPrice;

    @ApiModelProperty(notes = "会员等级名称")
    private String memberLevelName;
}