package com.dan.danauth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {
    private Integer id;

    private String userName;

    private String account;

    private String phone;

    private String password;

    private Integer status;

    private Integer orgId;

    private Integer orgType;

    private String description;

    private Integer createUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer updateUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private Integer roleId;
}