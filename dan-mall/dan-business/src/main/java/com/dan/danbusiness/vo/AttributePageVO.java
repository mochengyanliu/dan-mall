package com.dan.danbusiness.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-10 11:03 上午
 **/

@Data
@ApiModel("用户分页查询对象")
public class AttributePageVO extends PageVO {


    @ApiModelProperty(notes = "商品分类id")
    private Integer ProductAttributeCategoryId;

    @ApiModelProperty(notes = "属性类型")
    private Integer type;
}
