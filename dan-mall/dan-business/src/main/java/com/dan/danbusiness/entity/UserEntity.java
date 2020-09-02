package com.dan.danbusiness.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("用户对象")
public class UserEntity {

    @ApiModelProperty(notes = "用户ID")
    private Integer id;

    @ApiModelProperty(notes = "用户真实姓名")
    private String userName;

    @ApiModelProperty(notes = "账号")
    private String account;

    @ApiModelProperty(notes = "手机号")
    private String phone;

    @ApiModelProperty(notes = "等级")
    private Integer levelId;

    @ApiModelProperty(notes = "昵称")
    private String nickName;

    @ApiModelProperty(notes = "状态")
    private Integer status;

    @ApiModelProperty(notes = "类型")
    private Integer type;

    @ApiModelProperty(notes = "头像")
    private String icon;

    @ApiModelProperty(notes = "性别")
    private Integer gender;

    @ApiModelProperty(notes = "生日")
    private Date birthday;

    @ApiModelProperty(notes = "城市")
    private String city;

    @ApiModelProperty(notes = "工作")
    private String job;

    @ApiModelProperty(notes = "创建用户")
    private Integer createUser;

    @ApiModelProperty(notes = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(notes = "更新用户")
    private Integer updateUser;

    @ApiModelProperty(notes = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}