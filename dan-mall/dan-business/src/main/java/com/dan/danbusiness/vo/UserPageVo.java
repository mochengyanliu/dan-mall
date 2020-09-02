package com.dan.danbusiness.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lijun
 * @Description
 * @Date 2020-07-16 5:15 下午
 **/

@Data
@ApiModel("用户分页查询对象")
public class UserPageVo extends PageVO {

    @ApiModelProperty(notes = "用户真实姓名")
    private String userName;

    @ApiModelProperty(notes = "账号")
    private String account;

    @ApiModelProperty(notes = "手机号")
    private String phone;

    @ApiModelProperty(notes = "状态")
    private Integer status;

    @ApiModelProperty(notes = "类型")
    private Integer type;
}
