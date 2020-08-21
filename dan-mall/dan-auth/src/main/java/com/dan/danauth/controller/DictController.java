package com.dan.danauth.controller;

import com.dan.danauth.aop.EagleEye;
import com.dan.danauth.entity.DictEntity;
import com.dan.danauth.service.DictService;
import com.dan.dancommon.base.BaseRequestModel;
import com.dan.dancommon.base.BaseResponseModel;
import com.dan.dancommon.constants.RespCode;
import com.dan.dancommon.constants.RespMsg;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lijun
 * @Description 字典类型查询
 * @Date 2020-06-15 1:04 下午
 **/

@Log4j2
@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    DictService dictService;

    @EagleEye(desc = "字典类型查询接口")
    @RequestMapping(value = "/selectDictListByTypeId", method = RequestMethod.POST)
    public List<DictEntity> selectDictListByTypeId(@RequestParam(value = "typeId") Integer typeId) {
        return dictService.selectDictListByTypeId(typeId);
    }

    @EagleEye(desc = "字典类型查询接口")
    @RequestMapping(value = "/web/selectDictListByTypeId", method = RequestMethod.POST)
    public BaseResponseModel<Object> selectDictListByTypeId(@RequestBody BaseRequestModel request) {
        List<DictEntity> dictEntities =  dictService.selectDictListByTypeId(request.getReqData().getInteger("typeId"));
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepData(dictEntities);
        return response;
    }
}
