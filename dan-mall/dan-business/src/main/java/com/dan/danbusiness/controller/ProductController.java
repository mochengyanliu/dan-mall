package com.dan.danbusiness.controller;

import com.dan.danbusiness.aop.EagleEye;
import com.dan.danbusiness.service.ProductService;
import com.dan.danbusiness.vo.ProductVO;
import com.dan.dancommon.base.BaseRequestModelII;
import com.dan.dancommon.base.BaseResponseModel;
import com.dan.dancommon.constants.RespCode;
import com.dan.dancommon.constants.RespMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-17 4:47 下午
 **/

@RestController
@RequestMapping("/product")
@Api(tags = "商品模块")
public class ProductController {

    @Autowired
    private ProductService productService;

    @EagleEye(desc = "添加商品")
    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    @ApiOperation(value = "添加商品", notes = "")
    public BaseResponseModel<Object> insertProduct(@RequestBody BaseRequestModelII<ProductVO> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = productService.insertProduct(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else {
            response.setRepCode(RespCode.INSERT_PRODUCT_ERROR);
            response.setRepMsg(RespMsg.INSERT_PRODUCT_ERROR_MSG);
        }
        return response;
    }
}
