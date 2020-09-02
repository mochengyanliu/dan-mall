package com.dan.danbusiness.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author lijun
 * @Description
 * @Date 2020-07-17 10:45 上午
 **/

@Data
@ApiModel("用户权限数据模板")
public class UserHystrixVO {
    @ApiModelProperty(notes = "用户ID")
    private Integer id;

    @ApiModelProperty(notes = "用户真实姓名")
    private String userName;

    @ApiModelProperty(notes = "账号")
    private String account;

    @ApiModelProperty(notes = "手机号")
    private String phone;

    @ApiModelProperty(notes = "状态")
    private Integer status;

    @ApiModelProperty(notes = "组织ID")
    private Integer orgId;

    @ApiModelProperty(notes = "组织类型")
    private Integer orgType;

    @ApiModelProperty(notes = "描述")
    private String description;

    @ApiModelProperty(notes = "创建人")
    private Integer createUserId;

    @ApiModelProperty(notes = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(notes = "更新人")
    private Integer updateUserId;

    @ApiModelProperty(notes = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty(notes = "角色ID")
    private Integer roleId;
}
