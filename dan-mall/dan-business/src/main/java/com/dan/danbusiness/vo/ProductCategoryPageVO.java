package com.dan.danbusiness.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-06 9:20 上午
 **/

@Data
@ApiModel("商品")
public class ProductCategoryPageVO extends PageVO {

    @ApiModelProperty(notes = "名称")
    private String name;

    @ApiModelProperty(notes = "编码")
    private String code;

    @ApiModelProperty(notes = "展示状态")
    private Integer showStatus;
}
