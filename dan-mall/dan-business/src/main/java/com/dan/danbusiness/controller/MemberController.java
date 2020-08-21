package com.dan.danbusiness.controller;

import com.dan.danbusiness.aop.EagleEye;
import com.dan.danbusiness.entity.MemberLevelEntity;
import com.dan.danbusiness.service.MemberService;
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
 * @Date 2020-08-17 8:06 下午
 **/

@RestController
@RequestMapping("/member")
@Api(tags = "会员管理模块")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @EagleEye(desc = "添加会员等级")
    @RequestMapping(value = "/insertMemberLevel", method = RequestMethod.POST)
    @ApiOperation(value = "添加会员等级", notes = "")
    public BaseResponseModel<Object> insertMemberLevel(@RequestBody BaseRequestModelII<MemberLevelEntity> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = memberService.insertMemberLevel(request.getReqData());
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else if (count == -1) {
            response.setRepCode(RespCode.INSERT_MEMBER_LEVEL_REPEAT_ERROR);
            response.setRepMsg(RespMsg.INSERT_MEMBER_LEVEL_REPEAT_ERROR_MSG);
        } else {
            response.setRepCode(RespCode.INSERT_MEMBER_LEVEL_ERROR);
            response.setRepMsg(RespMsg.INSERT_MEMBER_LEVEL_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "修改会员等级")
    @RequestMapping(value = "/updateMemberLevel", method = RequestMethod.POST)
    @ApiOperation(value = "修改会员等级", notes = "")
    public BaseResponseModel<Object> updateMemberLevel(@RequestBody BaseRequestModelII<MemberLevelEntity> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = memberService.updateMemberLevel(request.getReqData());
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

    @EagleEye(desc = "查询会员等级列表")
    @RequestMapping(value = "/selectMemberLevelList", method = RequestMethod.POST)
    @ApiOperation(value = "查询会员等级列表", notes = "")
    public BaseResponseModel<Object> selectMemberLevelList(@RequestBody BaseRequestModelII<PageVO> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        Map<String, Object> map = memberService.selectMemberLevelList(request.getReqData());
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepData(map);
        return response;
    }


    @EagleEye(desc = "查询所有会员等级")
    @RequestMapping(value = "/selectAllMemberLevel", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有会员等级", notes = "")
    public BaseResponseModel<Object> selectAllMemberLevel(@RequestBody BaseRequestModel request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        List<MemberLevelEntity> memberLevelEntities = memberService.selectAllMemberLevel();
        Map<String, Object> map = new HashMap<>();
        map.put("memberLevelEntities", memberLevelEntities);
        response.setRepData(map);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepCode(RespCode.SUCCESS);
        return response;
    }

    @EagleEye(desc = "删除会员等级")
    @RequestMapping(value = "/deleteMemberLevel", method = RequestMethod.POST)
    @ApiOperation(value = "删除会员等级", notes = "会员等级id集合：ids")
    public BaseResponseModel<Object> deleteMemberLevel(@RequestBody BaseRequestModel request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        int count = memberService.deleteMemberLevel(request.getReqData().getString("ids"));
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
