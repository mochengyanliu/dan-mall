package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("收货地址对象")
public class ReceiveAddressEntity {

    @ApiModelProperty(notes = "收货地址ID")
    private Integer id;

    @ApiModelProperty(notes = "用户ID")
    private Integer userId;

    @ApiModelProperty(notes = "姓名")
    private String name;

    @ApiModelProperty(notes = "手机号")
    private String phoneNumber;

    @ApiModelProperty(notes = "状态")
    private Integer status;

    @ApiModelProperty(notes = "邮政编码")
    private String postCode;

    @ApiModelProperty(notes = "省份")
    private String province;

    @ApiModelProperty(notes = "城市")
    private String city;

    @ApiModelProperty(notes = "区县")
    private String region;

    @ApiModelProperty(notes = "详细地址")
    private String address;
}