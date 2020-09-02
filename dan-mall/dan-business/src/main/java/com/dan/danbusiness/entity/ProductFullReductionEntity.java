package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("商品满减对象")
public class ProductFullReductionEntity {

    @ApiModelProperty(notes = "商品满减ID")
    private Integer id;

    @ApiModelProperty(notes = "商品ID")
    private Integer productId;

    @ApiModelProperty(notes = "商品满足金额")
    private BigDecimal fullPrice;

    @ApiModelProperty(notes = "商品减少金额")
    private BigDecimal reducePrice;
}