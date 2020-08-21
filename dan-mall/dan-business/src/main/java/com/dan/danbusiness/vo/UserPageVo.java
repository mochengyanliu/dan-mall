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

    @ApiModelProperty(required = false, notes = "用户真实姓名", example = "王者")
    private String userName;

    @ApiModelProperty(required = false, notes = "账号", example = "admin")
    private String account;

    @ApiModelProperty(required = false, notes = "手机号", example = "17798987676")
    private String phone;

    @ApiModelProperty(required = false, notes = "状态", example = "1")
    private Integer status;

    @ApiModelProperty(required = false, notes = "类型", example = "1")
    private Integer type;
}
