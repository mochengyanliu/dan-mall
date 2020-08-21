package com.dan.dancommon.base;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lijun
 * @Description 返回类
 * @Date 2020-06-11 1:25 下午
 **/

@Data
@ApiModel("通用接口返回对象")
public class BaseResponseModel<T> {

    @ApiModelProperty(required = true, notes = "结果码", example = "0000")
    private String repCode;

    @ApiModelProperty(required = true, notes = "结果信息", example = "成功")
    private String repMsg;

    @ApiModelProperty(required = true, notes = "返回数据", example = "{\"name\":\"admin\"}")
    private T repData;

    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}
