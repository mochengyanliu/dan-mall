package com.dan.danauth.controller;

import com.dan.danauth.aop.EagleEye;
import com.dan.danauth.entity.RoleEntity;
import com.dan.danauth.service.RoleService;
import com.dan.danauth.vo.AuthPageVO;
import com.dan.danauth.vo.RolePageVO;
import com.dan.dancommon.base.BaseRequestModel;
import com.dan.dancommon.base.BaseRequestModelII;
import com.dan.dancommon.base.BaseResponseModel;
import com.dan.dancommon.constants.RespCode;
import com.dan.dancommon.constants.RespMsg;
import com.dan.dancommon.util.StringUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description 角色控制器类
 * @Date 2020-06-16 11:13 上午
 **/

@Log4j2
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @EagleEye(desc = "新增角色接口")
    @RequestMapping(value = "/insertRole", method = RequestMethod.POST)
    public BaseResponseModel<Object> insertRole(@RequestBody BaseRequestModelII<RoleEntity> request) {
        request.getReqData().setCreateUserId(request.getUserId());
        request.getReqData().setCreateTime(new Date());
        BaseResponseModel<Object> response = roleService.insertRole(request.getReqData());
        return response;
    }

    @EagleEye(desc = "修改角色接口")
    @RequestMapping(value = "/updateRole", method = RequestMethod.POST)
    public BaseResponseModel<Object> updateRole(@RequestBody BaseRequestModelII<RoleEntity> request) {
        BaseResponseModel<Object> response = roleService.updateRole(request.getReqData());
        return response;
    }

    @EagleEye(desc = "角色绑定权限接口")
    @RequestMapping(value = "/insertRoleAndAuth", method = RequestMethod.POST)
    public BaseResponseModel<Object> insertRoleAndAuth(@RequestBody BaseRequestModel request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        // 权限id
        Integer roleId = request.getReqData().getInteger("roleId");
        // 权限id
        List<Integer> authIds = (List<Integer>) request.getReqData().get("authIds");
        int count = roleService.insertRoleAndAuth(roleId, authIds);
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else {
            response.setRepCode(RespCode.INSERT_ROLE_AUTH_ERROR);
            response.setRepMsg(RespMsg.INSERT_ROLE_AUTH_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "修改权限状态接口")
    @RequestMapping(value = "/updateRoleStatus", method = RequestMethod.POST)
    public BaseResponseModel<Object> updateRoleStatus(@RequestBody BaseRequestModel request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        List<Integer> list;
        if (!StringUtil.isEmpty(request.getReqData().get("ids"), true)) {
            list = (List<Integer>) request.getReqData().get("ids");
        } else {
            response.setRepCode(RespCode.UPDATE_ROLE_STATUS_ERROR);
            response.setRepMsg(RespMsg.UPDATE_ROLE_STATUS_ERROR_MSG);
            return response;
        }
        if (list == null || list.size() == 0) {
            response.setRepCode(RespCode.UPDATE_ROLE_STATUS_ERROR);
            response.setRepMsg(RespMsg.UPDATE_ROLE_STATUS_ERROR_MSG);
            return response;
        }
        int count = roleService.updateRoleStatus(list, request.getReqData().getInteger("status"));
        if (count > 0) {
            response.setRepCode(RespCode.SUCCESS);
            response.setRepMsg(RespMsg.SUCCESS_MSG);
        } else if (count == -1){
            response.setRepCode(RespCode.UPDATE_STATUS_CHECK_ROLE_ERROR);
            response.setRepMsg(RespMsg.UPDATE_STATUS_CHECK_ROLE_ERROR_MSG);
        } else {
            response.setRepCode(RespCode.UPDATE_ROLE_STATUS_ERROR);
            response.setRepMsg(RespMsg.UPDATE_ROLE_STATUS_ERROR_MSG);
        }
        return response;
    }

    @EagleEye(desc = "根据用户查询角色id接口")
    @RequestMapping(value = "/selectRoleIdsByUserId", method = RequestMethod.POST)
    public List<Integer> selectRoleIdsByUserId(@RequestBody Integer userId) {
        return roleService.selectRoleIdsByUserId(userId);
    }

    @EagleEye(desc = "查询角色列表")
    @RequestMapping(value = "/selectRoleList", method = RequestMethod.POST)
    public BaseResponseModel<Object> selectRoleList(@RequestBody BaseRequestModelII<RolePageVO> request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        Map<String, Object> map = roleService.selectRoleList(request.getReqData());
        response.setRepData(map);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepCode(RespCode.SUCCESS);
        return response;
    }

    @EagleEye(desc = "查询所有角色接口")
    @RequestMapping(value = "/selectAllRole", method = RequestMethod.POST)
    public BaseResponseModel<Object> selectAllRole() {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        List<RoleEntity> roleEntities = roleService.selectAllRole();
        Map<String, Object> map = new HashMap<>();
        map.put("roleEntities", roleEntities);
        response.setRepData(map);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepCode(RespCode.SUCCESS);
        return response;
    }

    @EagleEye(desc = "根据角色id查询所有权限接口")
    @RequestMapping(value = "/selectAllAuthIdByRoleId", method = RequestMethod.POST)
    public BaseResponseModel<Object> selectAllAuthIdByRoleId(@RequestBody BaseRequestModel request) {
        BaseResponseModel<Object> response = new BaseResponseModel<>();
        List<Integer> list = roleService.selectAllAuthIdByRoleId(request.getReqData().getInteger("roleId"));
        Map<String, Object> map = new HashMap<>();
        map.put("authIds", list);
        response.setRepData(map);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        response.setRepCode(RespCode.SUCCESS);
        return response;
    }
}
