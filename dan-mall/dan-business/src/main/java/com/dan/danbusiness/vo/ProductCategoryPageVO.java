package com.dan.danbusiness.vo;

import lombok.Data;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-06 9:20 上午
 **/

@Data
public class ProductCategoryPageVO extends PageVO {

    private String name;

    private String code;

    private Integer showStatus;
}
