package com.dan.danauth.vo;

import lombok.Data;

/**
 * @Author lijun
 * @Description 角色分页类
 * @Date 2020-06-16 9:38 上午
 **/

@Data
public class RolePageVO {
    private String name;

    private Integer status;

    private int currentPage;

    private int pageNumber;

    private int dbIndex;

    private int dbNumber;
}
