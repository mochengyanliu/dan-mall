package com.dan.danauth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AuthEntity {
    private Integer id;

    private Integer sysId;

    private String name;

    private Integer status;

    private Integer type;

    private String url;

    private String authKey;

    private Integer sortNo;

    private Integer parentId;

    private String clazz;

    private String target;

    private String description;

    private Integer createUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer updateUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String parentName;
}