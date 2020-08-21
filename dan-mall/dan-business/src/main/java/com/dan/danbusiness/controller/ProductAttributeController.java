package com.dan.danbusiness.controller;

import com.dan.danbusiness.aop.EagleEye;
import com.dan.danbusiness.dto.ProductAttributeClassifyDTO;
import com.dan.danbusiness.entity.ProductAttributeEntity;
import com.dan.danbusiness.service.ProductAttributeService;
import com.dan.danbusiness.vo.AttributePageVO;
import com.dan.dancommon.base.BaseRequestModel;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-10 10:40 上午
 **/

@RestController
@RequestMapping("/productAttribute")
@Api(tags = "商品属性模块")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    @EagleEye(desc = "添加商品属性")
    @RequestMapping(value = "/insertProductAttribute", method = RequestMethod.POST)
    @ApiOperation(value = "添加商品属性", notes = "")
    public BaseResponseModel<Object> insertProductAttribute(@RequestBody BaseRequestModelII<ProductAttributeEntity> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = productAttributeService.insertProductAttribute(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else if (count == -1) {
            response.setRepCode(RespCode.INSERT_PRODUCT_ATTRIBUTE_REPEAT_ERROR);
            response.setRepMsg(RespMsg.INSERT_PRODUCT_ATTRIBUTE_REPEAT_ERROR_MSG);
        } else {
            response.setRepCode(RespCode.INSERT_PRODUCT_ATTRIBUTE_ERROR);
            response.setRepMsg(RespMsg.INSERT_PRODUCT_ATTRIBUTE_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "修改商品属性")
    @RequestMapping(value = "/updateProductAttribute", method = RequestMethod.POST)
    @ApiOperation(value = "修改商品属性", notes = "")
    public BaseResponseModel<Object> updateProductAttribute(@RequestBody BaseRequestModelII<ProductAttributeEntity> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = productAttributeService.updateProductAttribute(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else if (count == -1) {
            response.setRepCode(RespCode.UPDATE_PRODUCT_ATTRIBUTE_REPEAT_ERROR);
            response.setRepMsg(RespMsg.UPDATE_PRODUCT_ATTRIBUTE_REPEAT_ERROR_MSG);
        } else {
            response.setRepCode(RespCode.UPDATE_PRODUCT_ATTRIBUTE_ERROR);
            response.setRepMsg(RespMsg.UPDATE_PRODUCT_ATTRIBUTE_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "查询商品属性列表")
    @RequestMapping(value = "/selectProductAttributeList", method = RequestMethod.POST)
    @ApiOperation(value = "查询商品属性列表", notes = "")
    public BaseResponseModel<Object> selectProductAttributeList(@RequestBody BaseRequestModelII<AttributePageVO> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        Map<String, Object> map = productAttributeService.selectProductAttributeList(request.getReqData());
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepData(map);
        return response;
    }


    @EagleEye(desc = "查询所有商品属性")
    @RequestMapping(value = "/selectAllProductAttribute", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有商品属性", notes = "商品分类id-productAttributeCategoryId")
    public BaseResponseModel<Object> selectAllProductAttribute(@RequestBody BaseRequestModel request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        List<ProductAttributeEntity> productAttributeEntities = productAttributeService.selectAllProductAttribute(request.getReqData().getInteger("productAttributeCategoryId"));
        Map<String, Object> map = new HashMap<>();
        map.put("productAttributeEntities", productAttributeEntities);
        response.setRepData(map);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepCode(RespCode.SUCCESS);
        return response;
    }

    @EagleEye(desc = "删除商品属性")
    @RequestMapping(value = "/deleteProductAttribute", method = RequestMethod.POST)
    @ApiOperation(value = "删除商品属性", notes = "商品分类id：attributeCategoryId,属性id集合：ids,商品分类类型：type")
    public BaseResponseModel<Object> deleteProductAttribute(@RequestBody BaseRequestModel request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = productAttributeService.deleteProductAttribute(
                request.getReqData().getString("ids"),
                request.getReqData().getInteger("attributeCategoryId"),
                request.getReqData().getInteger("type"));
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else {
            response.setRepCode(RespCode.DELETE_PRODUCT_ATTRIBUTE_ERROR);
            response.setRepMsg(RespMsg.DELETE_PRODUCT_ATTRIBUTE_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "查询所有商品属性并分类")
    @RequestMapping(value = "/selectAllProductAttributeClassify", method = RequestMethod.POST)
    @ApiOperation(value = "删除商品属性", notes = "商品分类id：productAttributeCategoryId")
    public BaseResponseModel<Object> selectAllProductAttributeClassify(@RequestBody BaseRequestModel request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        List<ProductAttributeClassifyDTO> productAttributeClassifyDTOS = productAttributeService.selectAllProductAttributeClassify(request.getReqData().getInteger("productAttributeCategoryId"));
        Map<String, Object> map = new HashMap<>();
        map.put("productAttributeClassifyDTOS", productAttributeClassifyDTOS);
        response.setRepData(map);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepCode(RespCode.SUCCESS);
        return response;
    }
}
