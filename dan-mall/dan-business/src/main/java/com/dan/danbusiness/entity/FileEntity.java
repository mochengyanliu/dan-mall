package com.dan.danbusiness.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class FileEntity {
    private Integer id;

    private String name;

    private Integer type;

    private String path;

    private Integer status;

    private Long size;

    private String desc;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}