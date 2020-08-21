package com.dan.danauth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class LoginLogEntity {
    private Integer id;

    private Integer userId;

    private Integer sysId;

    private String ip;

    private Integer platform;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    private String description;
}