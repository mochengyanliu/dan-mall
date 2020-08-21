package com.dan.danauth.dto;

import lombok.Data;

import java.util.List;

/**
* @Description:
* @Author:         lijun
* @CreateDate:     2019/9/12 11:25 AM
* @Version:        1.0
*/
@Data
public class AuthEntityDTO {
    private Integer id;

    private String icon;

    private String title;

    private String name;

    private List<AuthEntityDTO> children;
}
