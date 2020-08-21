package com.dan.danbusiness.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("商品分类对象")
public class ProductCategoryEntity {
    @ApiModelProperty(required = false, notes = "商品分类id", example = "1")
    private Integer id;

    @ApiModelProperty(required = false, notes = "商品父级id", example = "1")
    private Integer parentId;

    @ApiModelProperty(required = true, notes = "商品分类名称", example = "王者")
    private String name;

    @ApiModelProperty(required = true, notes = "商品分类编码", example = "SH001")
    private String code;

    @ApiModelProperty(required = true, notes = "显示状态", example = "0->不显示；1->显示；2->删除")
    private Integer showStatus;

    @ApiModelProperty(required = true, notes = "排序", example = "1")
    private Integer sort;

    @ApiModelProperty(required = true, notes = "图标", example = "http://localhost:8080")
    private String icon;

    @ApiModelProperty(required = true, notes = "关键字", example = "王者")
    private String keywords;

    @ApiModelProperty(required = false, notes = "创建人", example = "1")
    private Integer createId;

    @ApiModelProperty(required = false, notes = "创建时间", example = "2020-02-02")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(required = false, notes = "修改人", example = "王者")
    private Integer updateId;

    @ApiModelProperty(required = false, notes = "修改时间", example = "2020-02-02")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty(required = false, notes = "描述", example = "王者")
    private String description;

    @ApiModelProperty(required = false, notes = "父级名称", example = "王者")
    private String parentName;
}