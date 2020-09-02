package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品分类对象")
public class ProductAttributeCategoryEntity {

    @ApiModelProperty(notes = "商品类型id")
    private Integer id;

    @ApiModelProperty(notes = "商品类型名称")
    private String name;

    @ApiModelProperty(notes = "用户真实姓名")
    private Integer attributeCount;

    @ApiModelProperty(notes = "用户真实姓名")
    private Integer paramCount;
}