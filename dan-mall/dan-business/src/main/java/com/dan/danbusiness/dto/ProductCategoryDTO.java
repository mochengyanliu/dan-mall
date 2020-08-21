package com.dan.danbusiness.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author lijun
 * @Description
 * @Date 2020-06-23 4:48 下午
 **/

@Data
public class ProductCategoryDTO {
    private Integer id;

    private String name;

    private List<ProductCategoryDTO> children;
}
