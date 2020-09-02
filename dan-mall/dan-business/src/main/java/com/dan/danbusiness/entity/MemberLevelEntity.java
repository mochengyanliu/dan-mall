package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("会员等级对象")
public class MemberLevelEntity {

    @ApiModelProperty(notes = "会员等级ID")
    private Integer id;

    @ApiModelProperty(notes = "名称")
    private String name;

    @ApiModelProperty(notes = "成长点")
    private Integer growthPoint;

    @ApiModelProperty(notes = "状态：0-不可用，1-启用，2-删除")
    private Integer status;

    @ApiModelProperty(notes = "排序")
    private Integer sort;

    @ApiModelProperty(notes = "免运费")
    private BigDecimal freeFreightPoint;

    @ApiModelProperty(notes = "评论增长点")
    private Integer commentGrowthPoint;

    @ApiModelProperty(notes = "免运费特权")
    private Integer privilegeFreeFreight;

    @ApiModelProperty(notes = "登陆特权")
    private Integer privilegeSignIn;

    @ApiModelProperty(notes = "评论特权")
    private Integer privilegeComment;

    @ApiModelProperty(notes = "提升特权")
    private Integer privilegePromotion;

    @ApiModelProperty(notes = "会员价格特权")
    private Integer privilegeMemberPrice;

    @ApiModelProperty(notes = "生日特权")
    private Integer privilegeBirthday;
}