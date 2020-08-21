package com.dan.danauth.vo;

import lombok.Data;

/**
 * @Author lijun
 * @Description 权限分页类
 * @Date 2020-06-16 9:38 上午
 **/

@Data
public class AuthPageVO {
    private String name;

    private Integer status;

    private Integer type;

    private int currentPage;

    private int pageNumber;

    private int dbIndex;

    private int dbNumber;
}
