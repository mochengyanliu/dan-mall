package com.dan.danbusiness.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-06 9:21 上午
 **/

@Data
@ApiModel("分页工具对象")
public class PageVO {

    @ApiModelProperty(required = true, notes = "当前页", example = "1")
    private int currentPage;

    @ApiModelProperty(required = true, notes = "每页大小", example = "10")
    private int pageNumber;

    @ApiModelProperty(notes = "数据库当前页", example = "0")
    private int dbIndex;

    @ApiModelProperty(notes = "数据库每页大小", example = "0")
    private int dbNumber;
}
