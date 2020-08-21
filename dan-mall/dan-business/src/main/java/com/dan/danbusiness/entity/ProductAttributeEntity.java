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

    @ApiModelProperty(required = false, notes = "商品属性id", example = "1")
    private Integer id;

    @ApiModelProperty(required = true, notes = "商品分类id", example = "1")
    private Integer productAttributeCategoryId;

    @ApiModelProperty(required = true, notes = "名称", example = "王者")
    private String name;

    @ApiModelProperty(required = true, notes = "选择类型", example = "0-单选，1-多选")
    private Integer selectType;

    @ApiModelProperty(required = true, notes = "属性录入方式", example = "0-手工录入，1-列表选择")
    private Integer inputType;

    @ApiModelProperty(required = false, notes = "可选值列表", example = "黄色,蓝色,紫色")
    private String inputList;

    @ApiModelProperty(required = true, notes = "排序", example = "1")
    private Integer sort;

    @ApiModelProperty(required = false, notes = "类型", example = "0-规格，1-参数")
    private Integer type;

    @ApiModelProperty(required = false, notes = "商品分类名称", example = "")
    private String attributeCategoryName;

    @ApiModelProperty(required = false, notes = "商品可选值集合", example = "")
    private List<String> inputLists;

    public List<String> getInputLists() {
        if (StringUtil.isEmpty(inputList,true)){
            return null;
        }
        return Arrays.asList(inputList.split(","));
    }
}