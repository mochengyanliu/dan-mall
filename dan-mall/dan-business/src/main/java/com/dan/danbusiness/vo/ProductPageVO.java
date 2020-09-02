package com.dan.danbusiness.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-31 7:16 下午
 **/
@Data
public class ProductPageVO extends PageVO {


    @ApiModelProperty(notes = "商品名称")
    private String name;

    @ApiModelProperty(notes = "商品货号")
    private String productSn;

    @ApiModelProperty(notes = "商品分类")
    private Integer productCategoryId;

    @ApiModelProperty(notes = "上架状态：0->下架；1->上架")
    private Integer publishStatus;
}
