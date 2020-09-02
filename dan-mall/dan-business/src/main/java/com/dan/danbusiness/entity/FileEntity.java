package com.dan.danbusiness.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("文件对象")
public class FileEntity {

    @ApiModelProperty(notes = "文件ID")
    private Integer id;

    @ApiModelProperty(notes = "名称")
    private String name;

    @ApiModelProperty(notes = "类型")
    private Integer type;

    @ApiModelProperty(notes = "路径")
    private String path;

    @ApiModelProperty(notes = "状态")
    private Integer status;

    @ApiModelProperty(notes = "大小")
    private Long size;

    @ApiModelProperty(notes = "描述")
    private String desc;

    @ApiModelProperty(notes = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}