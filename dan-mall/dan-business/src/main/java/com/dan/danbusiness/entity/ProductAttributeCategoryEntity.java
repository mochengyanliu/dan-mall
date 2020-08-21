package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("商品分类对象")
public class ProductAttributeCategoryEntity {

    @ApiModelProperty(required = false, notes = "商品类型id", example = "1")
    private Integer id;

    @ApiModelProperty(required = true, notes = "商品类型名称", example = "电子产品")
    private String name;

    @ApiModelProperty(required = false, notes = "用户真实姓名", example = "规格数量")
    private Integer attributeCount;

    @ApiModelProperty(required = false, notes = "用户真实姓名", example = "参数数量")
    private Integer paramCount;
}