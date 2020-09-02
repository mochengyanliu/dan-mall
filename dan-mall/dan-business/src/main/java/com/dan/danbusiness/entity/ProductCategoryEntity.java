package com.dan.danbusiness.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("商品分类对象")
public class ProductCategoryEntity {
    @ApiModelProperty(notes = "商品分类id")
    private Integer id;

    @ApiModelProperty(notes = "商品父级id")
    private Integer parentId;

    @ApiModelProperty(notes = "商品分类名称")
    private String name;

    @ApiModelProperty(notes = "商品分类编码")
    private String code;

    @ApiModelProperty(notes = "显示状态")
    private Integer showStatus;

    @ApiModelProperty(notes = "排序")
    private Integer sort;

    @ApiModelProperty(notes = "图标")
    private String icon;

    @ApiModelProperty(notes = "关键字")
    private String keywords;

    @ApiModelProperty(notes = "创建人")
    private Integer createId;

    @ApiModelProperty(notes = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(notes = "修改人")
    private Integer updateId;

    @ApiModelProperty(notes = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty(notes = "描述")
    private String description;

    @ApiModelProperty(notes = "父级名称")
    private String parentName;
}