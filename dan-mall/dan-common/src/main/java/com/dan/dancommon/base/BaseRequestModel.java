package com.dan.dancommon.base;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lijun
 * @Description 接收无实体类
 * @Date 2020-06-11 1:21 下午
 **/

@Data
@ApiModel("请求接口通用接收对象")
public class BaseRequestModel {

    @ApiModelProperty(required = true, notes = "token", example = "4a7d1ed414474e4033ac29ccb8653d9b")
    private String token;

    @ApiModelProperty(required = true, notes = "用户ID", example = "1")
    private Integer userId;

    @ApiModelProperty(required = true, notes = "签名", example = "dcddb75469b4b4875094e14561e573d8")
    private String sign;

    @ApiModelProperty(required = true, notes = "时间戳", example = "1596433801")
    private String time;

    @ApiModelProperty(required = true, notes = "请求参数", example = "{\"name\":\"admin\"}")
    private JSONObject reqData;
}
