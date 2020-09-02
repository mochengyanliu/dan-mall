package com.dan.danbusiness.controller;

import com.dan.danbusiness.aop.EagleEye;
import com.dan.danbusiness.dto.ProductCategoryDTO;
import com.dan.danbusiness.entity.ProductCategoryEntity;
import com.dan.danbusiness.service.ProductCategoryService;
import com.dan.danbusiness.vo.ProductCategoryPageVO;
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
 * @Description 商品分类控制器
 * @Date 2020-06-23 3:08 下午
 **/

@RestController
@RequestMapping("/productCategory")
@Api(tags = "商品规格模块")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @EagleEye(desc = "商品分类规格")
    @RequestMapping(value = "/addProductCategory", method = RequestMethod.POST)
    @ApiOperation(value = "添加商品分类", notes = "")
    public BaseResponseModel<Object> addProductCategory(@RequestBody BaseRequestModelII<ProductCategoryEntity> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        request.getReqData().setCreateId(request.getUserId());
        int count = productCategoryService.addProductCategory(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else if (count == -1) {
            response.setRepCode(RespCode.ADD_PRODUCT_CATEGORY_REPEAT_ERROR);
            response.setRepMsg(RespMsg.ADD_PRODUCT_CATEGORY_REPEAT_ERROR_MSG);
        } else {
            response.setRepCode(RespCode.ADD_PRODUCT_CATEGORY_ERROR);
            response.setRepMsg(RespMsg.ADD_PRODUCT_CATEGORY_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "修改产品分类")
    @RequestMapping(value = "/updateProductCategory", method = RequestMethod.POST)
    @ApiOperation(value = "修改产品分类", notes = "")
    public BaseResponseModel<Object> updateProductCategory(@RequestBody BaseRequestModelII<ProductCategoryEntity> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        request.getReqData().setUpdateId(request.getUserId());
        int count = productCategoryService.updateProductCategory(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else if (count == -1) {
            response.setRepCode(RespCode.UPDATE_PRODUCT_CATEGORY_REPEAT_ERROR);
            response.setRepMsg(RespMsg.UPDATE_PRODUCT_CATEGORY_REPEAT_ERROR_MSG);
        } else {
            response.setRepCode(RespCode.UPDATE_PRODUCT_CATEGORY_ERROR);
            response.setRepMsg(RespMsg.UPDATE_PRODUCT_CATEGORY_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "查询商品分类列表")
    @RequestMapping(value = "/selectProductCategoryList", method = RequestMethod.POST)
    @ApiOperation(value = "查询商品分类列表", notes = "")
    public BaseResponseModel<Object> selectProductCategoryList(@RequestBody BaseRequestModelII<ProductCategoryPageVO> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        Map<String, Object> map = productCategoryService.selectProductCategoryList(request.getReqData());
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepData(map);
        return response;
    }

    @EagleEye(desc = "查询商品分类树")
    @RequestMapping(value = "/selectProductCategoryTree", method = RequestMethod.POST)
    @ApiOperation(value = "查询商品分类树", notes = "")
    public BaseResponseModel<Object> selectProductCategoryTree() {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        Map<String, Object> map = new HashMap();
        List<ProductCategoryDTO> productCategoryDTOS = productCategoryService.selectProductCategoryTree();
        map.put("productCategoryDTOS", productCategoryDTOS);
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepData(map);
        return response;
    }

    @EagleEye(desc = "查询所有商品分类接口")
    @RequestMapping(value = "/selectAllProductCategory", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有商品分类接口", notes = "")
    public BaseResponseModel<Object> selectAllProductCategory() {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        List<ProductCategoryEntity> productCategoryEntities = productCategoryService.selectAllProductCategory();
        Map<String, Object> map = new HashMap<>();
        map.put("productCategoryEntities", productCategoryEntities);
        response.setRepData(map);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepCode(RespCode.SUCCESS);
        return response;
    }

    @EagleEye(desc = "删除商品分类")
    @RequestMapping(value = "/deleteProductCategory", method = RequestMethod.POST)
    @ApiOperation(value = "删除商品分类", notes = "商品属性Id集合")
    public BaseResponseModel<Object> deleteProductCategory(@RequestBody BaseRequestModel request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = productCategoryService.deleteProductCategory(request.getReqData().getString("ids"));
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else {
            response.setRepCode(RespCode.DELETE_PRODUCT_ATTRIBUTE_ERROR);
            response.setRepMsg(RespMsg.DELETE_PRODUCT_ATTRIBUTE_ERROR_MSG);
        }
        return response;
    }
}
