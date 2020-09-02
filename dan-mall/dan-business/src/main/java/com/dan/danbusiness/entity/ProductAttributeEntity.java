package com.dan.danbusiness.entity;

import com.dan.dancommon.util.StringUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@ApiModel("商品属性对象")
public class ProductAttributeEntity {

    @ApiModelProperty(notes = "商品属性id")
    private Integer id;

    @ApiModelProperty(notes = "商品分类id")
    private Integer productAttributeCategoryId;

    @ApiModelProperty(notes = "名称")
    private String name;

    @ApiModelProperty(notes = "选择类型")
    private Integer selectType;

    @ApiModelProperty(notes = "属性录入方式")
    private Integer inputType;

    @ApiModelProperty(notes = "可选值列表")
    private String inputList;

    @ApiModelProperty(notes = "排序")
    private Integer sort;

    @ApiModelProperty(notes = "类型")
    private Integer type;

    @ApiModelProperty(notes = "商品分类名称")
    private String attributeCategoryName;

    @ApiModelProperty(notes = "商品可选值集合")
    private List<String> inputLists;

    public List<String> getInputLists() {
        if (StringUtil.isEmpty(inputList,true)){
            return null;
        }
        return Arrays.asList(inputList.split(","));
    }
}