package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("商品SKU对象")
public class SkuStockEntity {

    @ApiModelProperty(notes = "商品SKUID")
    private Integer id;

    @ApiModelProperty(notes = "商品ID")
    private Integer productId;

    @ApiModelProperty(notes = "sku编码")
    private String skuCode;

    @ApiModelProperty(notes = "价格")
    private BigDecimal price;

    @ApiModelProperty(notes = "库存")
    private Integer stock;

    @ApiModelProperty(notes = "预警库存")
    private Integer lowStock;

    @ApiModelProperty(notes = "规格1")
    private String sp1;

    @ApiModelProperty(notes = "规格2")
    private String sp2;

    @ApiModelProperty(notes = "规格3")
    private String sp3;

    @ApiModelProperty(notes = "展示图片")
    private String pic;

    @ApiModelProperty(notes = "销量")
    private Integer sale;
}