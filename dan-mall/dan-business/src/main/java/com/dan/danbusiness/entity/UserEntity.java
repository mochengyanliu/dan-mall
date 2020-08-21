package com.dan.danbusiness.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("用户对象")
public class UserEntity {

    @ApiModelProperty(required = false, notes = "用户ID", example = "1")
    private Integer id;

    @ApiModelProperty(required = true, notes = "用户真实姓名", example = "王者")
    private String userName;

    @ApiModelProperty(required = true, notes = "账号", example = "admin")
    private String account;

    @ApiModelProperty(required = true, notes = "手机号", example = "17789896767")
    private String phone;

    @ApiModelProperty(required = false, notes = "等级", example = "1")
    private Integer levelId;

    @ApiModelProperty(required = true, notes = "昵称", example = "王者荣耀")
    private String nickName;

    @ApiModelProperty(required = true, notes = "状态", example = "1")
    private Integer status;

    @ApiModelProperty(required = true, notes = "类型", example = "1")
    private Integer type;

    @ApiModelProperty(required = false, notes = "头像", example = "http://localhost:8080")
    private String icon;

    @ApiModelProperty(required = false, notes = "性别", example = "1")
    private Integer gender;

    @ApiModelProperty(required = false, notes = "生日", example = "2020-02-02")
    private Date birthday;

    @ApiModelProperty(required = false, notes = "城市", example = "上海")
    private String city;

    @ApiModelProperty(required = false, notes = "工作", example = "程序员")
    private String job;

    @ApiModelProperty(required = false, notes = "创建用户", example = "1")
    private Integer createUser;

    @ApiModelProperty(required = false, notes = "创建时间", example = "")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(required = false, notes = "更新用户", example = "1")
    private Integer updateUser;

    @ApiModelProperty(required = false, notes = "更新时间", example = "")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}