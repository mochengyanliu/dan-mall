package com.dan.danbusiness.entity;

import lombok.Data;

@Data
public class ReceiveAddressEntity {
    private Integer id;

    private Integer userId;

    private String name;

    private String phoneNumber;

    private Integer status;

    private String postCode;

    private String province;

    private String city;

    private String region;

    private String address;
}