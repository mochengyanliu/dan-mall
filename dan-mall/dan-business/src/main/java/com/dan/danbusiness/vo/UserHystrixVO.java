package com.dan.danbusiness.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author lijun
 * @Description
 * @Date 2020-07-17 10:45 上午
 **/

@Data
public class UserHystrixVO {
    private Integer id;

    private String userName;

    private String account;

    private String phone;

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
