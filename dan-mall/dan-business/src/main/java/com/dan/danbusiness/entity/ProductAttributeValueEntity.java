package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品属性关联对象")
public class ProductAttributeValueEntity {

    @ApiModelProperty(notes = "商品属性关联ID")
    private Integer id;

    @ApiModelProperty(notes = "商品主键")
    private Integer productId;

    @ApiModelProperty(notes = "商品属性ID")
    private Integer productAttributeId;

    @ApiModelProperty(notes = "可选值列表，以逗号隔开")
    private String inputList;

    @ApiModelProperty(notes = "属性图片")
    private Integer pic;
}