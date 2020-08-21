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


    @ApiModelProperty(required = false, notes = "商品分类id", example = "1")
    private Integer ProductAttributeCategoryId;

    @ApiModelProperty(required = false, notes = "属性类型", example = "0-规格，1-参数")
    private Integer type;
}
