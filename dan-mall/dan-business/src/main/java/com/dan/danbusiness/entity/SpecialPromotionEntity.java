package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("特惠促销对象")
public class SpecialPromotionEntity {

    @ApiModelProperty(notes = "特惠促销ID")
    private Integer id;

    @ApiModelProperty(notes = "商品ID")
    private Integer productId;

    @ApiModelProperty(notes = "开始时间")
    private Date beginTime;

    @ApiModelProperty(notes = "结束时间")
    private Date endTime;

    @ApiModelProperty(notes = "促销价格")
    private BigDecimal price;
}