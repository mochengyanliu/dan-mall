package com.dan.danbusiness.controller;

import com.dan.danbusiness.aop.EagleEye;
import com.dan.danbusiness.entity.ProductAttributeCategoryEntity;
import com.dan.danbusiness.service.ProductAttributeCategoryService;
import com.dan.danbusiness.vo.PageVO;
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
 * @Date 2020-08-07 3:49 下午
 **/

@RestController
@RequestMapping("/productAttributeCategory")
@Api(tags = "商品分类模块")
public class ProductAttributeCategoryController {

    @Autowired
    private ProductAttributeCategoryService productAttributeCategoryService;

    @EagleEye(desc = "添加商品类型")
    @RequestMapping(value = "/insertProductAttributeCategory", method = RequestMethod.POST)
    @ApiOperation(value = "添加商品类型", notes = "")
    public BaseResponseModel<Object> insertProductAttributeCategory(@RequestBody BaseRequestModelII<ProductAttributeCategoryEntity> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = productAttributeCategoryService.insertProductAttributeCategory(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else if (count == -1) {
            response.setRepCode(RespCode.INSERT_PRODUCT_ATTRIBUTE_CATEGORY_REPEAT_ERROR);
            response.setRepMsg(RespMsg.INSERT_PRODUCT_ATTRIBUTE_CATEGORY_REPEAT_ERROR_MSG);
        } else {
            response.setRepCode(RespCode.INSERT_PRODUCT_ATTRIBUTE_CATEGORY_ERROR);
            response.setRepMsg(RespMsg.INSERT_PRODUCT_ATTRIBUTE_CATEGORY_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "修改商品类型")
    @RequestMapping(value = "/updateProductAttributeCategory", method = RequestMethod.POST)
    @ApiOperation(value = "修改商品类型", notes = "")
    public BaseResponseModel<Object> updateProductAttributeCategory(@RequestBody BaseRequestModelII<ProductAttributeCategoryEntity> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = productAttributeCategoryService.updateProductAttributeCategory(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else if (count == -1) {
            response.setRepCode(RespCode.UPDATE_PRODUCT_ATTRIBUTE_CATEGORY_REPEAT_ERROR);
            response.setRepMsg(RespMsg.UPDATE_PRODUCT_ATTRIBUTE_CATEGORY_REPEAT_ERROR_MSG);
        } else {
            response.setRepCode(RespCode.UPDATE_PRODUCT_ATTRIBUTE_CATEGORY_ERROR);
            response.setRepMsg(RespMsg.UPDATE_PRODUCT_ATTRIBUTE_CATEGORY_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "查询商品类型列表")
    @RequestMapping(value = "/selectProductAttributeCategoryList", method = RequestMethod.POST)
    @ApiOperation(value = "查询商品类型列表", notes = "")
    public BaseResponseModel<Object> selectProductAttributeCategoryList(@RequestBody BaseRequestModelII<PageVO> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        Map<String, Object> map = productAttributeCategoryService.selectProductAttributeCategoryList(request.getReqData());
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepData(map);
        return response;
    }


    @EagleEye(desc = "查询所有商品分类")
    @RequestMapping(value = "/selectAllProductAttributeCategory", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有商品分类", notes = "")
    public BaseResponseModel<Object> selectAllProductAttributeCategory() {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        List<ProductAttributeCategoryEntity> productAttributeCategoryEntities = productAttributeCategoryService.selectAllProductAttributeCategory();
        Map<String, Object> map = new HashMap<>();
        map.put("productAttributeCategoryEntities", productAttributeCategoryEntities);
        response.setRepData(map);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepCode(RespCode.SUCCESS);
        return response;
    }

    @EagleEye(desc = "删除商品分类")
    @RequestMapping(value = "/deleteProductAttributeCategory", method = RequestMethod.POST)
    @ApiOperation(value = "删除商品分类", notes = "商品分类Id集合")
    public BaseResponseModel<Object> deleteProductAttributeCategory(@RequestBody BaseRequestModel request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = productAttributeCategoryService.deleteProductAttributeCategory(request.getReqData().getString("ids"));
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else {
            response.setRepCode(RespCode.DELETE_PRODUCT_ATTRIBUTE_CATEGORY_ERROR);
            response.setRepMsg(RespMsg.DELETE_PRODUCT_ATTRIBUTE_CATEGORY_ERROR_MSG);
        }
        return response;
    }
}
