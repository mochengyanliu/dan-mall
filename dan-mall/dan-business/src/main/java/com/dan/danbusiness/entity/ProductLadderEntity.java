package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("商品阶梯价格对象")
public class ProductLadderEntity {

    @ApiModelProperty(notes = "商品阶梯价格ID")
    private Integer id;

    @ApiModelProperty(notes = "商品满ID")
    private Integer productId;

    @ApiModelProperty(notes = "满足商品的数量")
    private Integer count;

    @ApiModelProperty(notes = "折扣")
    private BigDecimal discount;

    @ApiModelProperty(notes = "折后价格")
    private BigDecimal price;
}