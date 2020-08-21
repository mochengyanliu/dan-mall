package com.dan.danauth.service.impl;

import com.dan.danauth.dto.AuthEntityDTO;
import com.dan.danauth.dto.ButtonEntityDTO;
import com.dan.danauth.entity.AuthEntity;
import com.dan.danauth.entity.RoleEntity;
import com.dan.danauth.entity.UserEntity;
import com.dan.danauth.mapper.AuthEntityMapper;
import com.dan.danauth.mapper.RoleEntityMapper;
import com.dan.danauth.mapper.UserEntityMapper;
import com.dan.danauth.service.LoginService;
import com.dan.dancommon.base.BaseResponseModel;
import com.dan.dancommon.constants.RespCode;
import com.dan.dancommon.constants.RespMsg;
import com.dan.dancommon.enums.Constant;
import com.dan.dancommon.util.MD5Util;
import com.dan.dancommon.util.RedisUtil;
import com.dan.dancommon.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author lijun
 * @Description
 * @Date 2020-06-16 5:23 下午
 **/

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private UserEntityMapper userEntityMapper;

    @Autowired
    private RoleEntityMapper roleEntityMapper;

    @Autowired
    private AuthEntityMapper authEntityMapper;

    @Override
    public BaseResponseModel<Object> login(String account, String password, String code, String pCode) {
        BaseResponseModel response = new BaseResponseModel();

        // 检验验证码错误次数
        String errorpw = "ERRORPW" + account;
        Integer count = 0;
        if (redisUtil.hasKey(errorpw)) {
            count = (Integer) redisUtil.get(errorpw);
            if (count >= 3) {
                // 密码错误3次
                response.setRepCode(RespCode.LOGIN_PASSWORD_WRONG_OUT_ERROR);
                response.setRepMsg(RespMsg.LOGIN_PASSWORD_WRONG_OUT_ERROR_MSG);
                return response;
            }
        }

        // 检验参数是否正确
        if (StringUtil.isEmpty(account, true)) {
            // 用户名为空
            response.setRepCode(RespCode.LOGIN_WITHOUT_ACCOUNT_ERROR);
            response.setRepMsg(RespMsg.LOGIN_WITHOUT_ACCOUNT_ERROR_MSG);
            return response;
        } else if (StringUtil.isEmpty(password, true)) {
            // 密码为空
            response.setRepCode(RespCode.LOGIN_WITHOUT_PASSWORD_ERROR);
            response.setRepMsg(RespMsg.LOGIN_WITHOUT_PASSWORD_ERROR_MSG);
            return response;
        } else if (StringUtil.isEmpty(pCode, true) || StringUtil.isEmpty(code, true)) {
            // 验证信息为空
            response.setRepCode(RespCode.LOGIN_WITHOUT_CODE_ERROR);
            response.setRepMsg(RespMsg.LOGIN_WITHOUT_CODE_ERROR_MSG);
            return response;
        } else if (redisUtil.get(pCode) == null) {
            // 验证码过期
            response.setRepCode(RespCode.LOGIN_CODE_OVER_ERROR);
            response.setRepMsg(RespMsg.LOGIN_CODE_OVER_ERROR_MSG);
            return response;
        } else if (!code.toUpperCase().equals(redisUtil.get(pCode).toString().toUpperCase())) {
            //验证码强制过期
            redisUtil.del(pCode);
            // 验证码错误
            response.setRepCode(RespCode.LOGIN_CODE_WRONG_ERROR);
            response.setRepMsg(RespMsg.LOGIN_CODE_WRONG_ERROR_MSG);
            return response;
        }
        //验证码强制过期
        redisUtil.del(pCode);

        // 查询用户
        UserEntity userEntity = userEntityMapper.login(account);
        List<RoleEntity> roleEntityList;
        if (userEntity != null) {
            password = MD5Util.getMD5Code(Constant.PARENT_ID.getValue() + password);
            if (!userEntity.getPassword().equals(password)){
                //计算验证码错误次数
                count++;
                if (count == 1) {
                    redisUtil.set(errorpw, count, 30 * 60);
                    response.setRepCode(RespCode.LOGIN_PASSWORD_WRONG_ONE_ERROR);
                    response.setRepMsg(RespMsg.LOGIN_PASSWORD_WRONG_ONE_ERROR_MSG);
                } else if (count == 2) {
                    redisUtil.set(errorpw, count, 30 * 60);
                    response.setRepCode(RespCode.LOGIN_PASSWORD_WRONG_TWO_ERROR);
                    response.setRepMsg(RespMsg.LOGIN_PASSWORD_WRONG_TWO_ERROR_MSG);
                } else if (count >= 3) {
                    redisUtil.set(errorpw, count, 3 * 60 * 60);
                    response.setRepCode(RespCode.LOGIN_PASSWORD_WRONG_OUT_ERROR);
                    response.setRepMsg(RespMsg.LOGIN_PASSWORD_WRONG_OUT_ERROR_MSG);
                }
                return response;
            }

            if (!userEntity.getStatus().equals(1)) {
                // 用户状态不可用
                response.setRepCode(RespCode.LOGIN_USERNAME_STATUS_ERROR);
                response.setRepMsg(RespMsg.LOGIN_USERNAME_STATUS_ERROR_MSG);
                return response;
            }
            // 查询角色
            roleEntityList = roleEntityMapper.selectRoleByUserId(userEntity.getId());
            List<Integer> ids = new ArrayList<>();
            for (RoleEntity role : roleEntityList) {
                ids.add(role.getId());
            }
            //查询权限
            List<AuthEntity> authEntityList = authEntityMapper.selectAuthByRoleIds(ids);
            List<AuthEntityDTO> authEntityDTOS = getAuth(0, authEntityList);

            // 查询按钮
            Map<String, Object> buttonMap = new HashMap<>();
            for (AuthEntity authEntity : authEntityList) {
                List<ButtonEntityDTO> buttonEntityDTOS = new ArrayList<>();
                List<AuthEntity> buttonEntitis = authEntityMapper.selectAuthByParentId(ids, authEntity.getId());
                for (AuthEntity auth : buttonEntitis) {
                    ButtonEntityDTO buttonEntityDTO = new ButtonEntityDTO();
                    buttonEntityDTO.setId(auth.getId());
                    buttonEntityDTO.setIcon(auth.getClazz());
                    buttonEntityDTO.setText(auth.getName());
                    buttonEntityDTO.setType(auth.getUrl());
                    buttonEntityDTOS.add(buttonEntityDTO);
                }
                buttonMap.put(authEntity.getUrl(), buttonEntityDTOS);
            }

            Map<String, Object> map = new HashMap<>();
            map.put("userEntity", userEntity);
            map.put("roleEntityList", roleEntityList);
            map.put("authEntityDTOS", authEntityDTOS);
            map.put("buttonMap", buttonMap);

            // 生成token
            String token = MD5Util.getMD5Code(String.valueOf(System.currentTimeMillis() + new Random().nextInt(999999999)));
            redisUtil.set(userEntity.getId().toString(), token, 24 * 60 * 60);
            map.put("token", token);
            response.setRepData(map);
        } else {
            // 账号错误
            response.setRepCode(RespCode.LOGIN_USERNAME_WRONG_ERROR);
            response.setRepMsg(RespMsg.LOGIN_USERNAME_WRONG_ERROR_MSG);
            return response;
        }
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        return response;
    }

    @Override
    public BaseResponseModel<Object> loginByPhone(String phone, String code, String pCode) {
        BaseResponseModel response = new BaseResponseModel();

        // 检验验证码错误次数
        String errorpw = "ERRORPW" + phone;
        Integer count = 0;
        if (redisUtil.hasKey(errorpw)) {
            count = (Integer) redisUtil.get(errorpw);
            if (count >= 3) {
                // 密码错误3次
                response.setRepCode(RespCode.LOGIN_CODE_WRONG_OUT_ERROR);
                response.setRepMsg(RespMsg.LOGIN_CODE_WRONG_OUT_ERROR_MSG);
                return response;
            }
        }

        // 检验参数是否正确
        if (StringUtil.isEmpty(phone, true)) {
            // 手机号为空
            response.setRepCode(RespCode.LOGIN_WITHOUT_PHONE_ERROR);
            response.setRepMsg(RespMsg.LOGIN_WITHOUT_PHONE_ERROR_MSG);
            return response;
        } else if (StringUtil.isEmpty(pCode, true) || StringUtil.isEmpty(code, true)) {
            // 验证信息为空
            response.setRepCode(RespCode.LOGIN_WITHOUT_CODE_ERROR);
            response.setRepMsg(RespMsg.LOGIN_WITHOUT_CODE_ERROR_MSG);
            return response;
        } else if (redisUtil.get(pCode) == null) {
            // 验证码过期
            response.setRepCode(RespCode.LOGIN_CODE_OVER_ERROR);
            response.setRepMsg(RespMsg.LOGIN_CODE_OVER_ERROR_MSG);
            return response;
        } else if (!code.toUpperCase().equals(redisUtil.get(pCode).toString().toUpperCase())) {
            //验证码强制过期
            redisUtil.del(pCode);

            //计算验证码错误次数
            count++;
            if (count == 1) {
                redisUtil.set(errorpw, count, 30 * 60);
                response.setRepCode(RespCode.LOGIN_CODE_WRONG_ONE_ERROR);
                response.setRepMsg(RespMsg.LOGIN_CODE_WRONG_ONE_ERROR_MSG);
            } else if (count == 2) {
                redisUtil.set(errorpw, count, 30 * 60);
                response.setRepCode(RespCode.LOGIN_CODE_WRONG_TWO_ERROR);
                response.setRepMsg(RespMsg.LOGIN_CODE_WRONG_TWO_ERROR_MSG);
            } else if (count >= 3) {
                redisUtil.set(errorpw, count, 3 * 60 * 60);
                response.setRepCode(RespCode.LOGIN_CODE_WRONG_OUT_ERROR);
                response.setRepMsg(RespMsg.LOGIN_CODE_WRONG_OUT_ERROR_MSG);
            }
            return response;
        }
        //验证码强制过期
        redisUtil.del(pCode);

        // 查询用户
        UserEntity userEntity = userEntityMapper.loginByPhone(phone);
        List<RoleEntity> roleEntityList;
        if (userEntity != null) {
            if (!userEntity.getStatus().equals(1)) {
                // 用户状态不可用
                response.setRepCode(RespCode.LOGIN_USERNAME_STATUS_ERROR);
                response.setRepMsg(RespMsg.LOGIN_USERNAME_STATUS_ERROR_MSG);
                return response;
            }
            Map<String, Object> map = new HashMap<>();
            map.put("userEntity", userEntity);

            // 生成token
            String token = MD5Util.getMD5Code(String.valueOf(System.currentTimeMillis() + new Random().nextInt(999999999)));
            redisUtil.set(userEntity.getId().toString(), token);
            map.put("token", token);
            response.setRepData(map);
        } else {
            // 手机号错误
            response.setRepCode(RespCode.LOGIN_PHONE_WRONG_ERROR);
            response.setRepMsg(RespMsg.LOGIN_PHONE_WRONG_ERROR_MSG);
            return response;
        }
        response.setRepCode(RespCode.SUCCESS);
        response.setRepMsg(RespMsg.SUCCESS_MSG);
        return response;
    }

    @Override
    public int checkPhone(String phone) {
        UserEntity userEntity = userEntityMapper.loginByPhone(phone);
        if (userEntity == null){
            return 0;
        } else {
            return userEntity.getId();
        }
    }

    /**
     * 递归获取权限
     *
     * @param authId
     * @param list
     * @return
     */
    public static List<AuthEntityDTO> getAuth(Integer authId, List<AuthEntity> list) {
        List<AuthEntityDTO> authEntities = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (authId.equals(list.get(i).getParentId())) {
                AuthEntityDTO authEntityDTO = new AuthEntityDTO();
                authEntityDTO.setId(list.get(i).getId());
                authEntityDTO.setIcon(list.get(i).getClazz());
                authEntityDTO.setName(list.get(i).getTarget());
                authEntityDTO.setTitle(list.get(i).getName());
                authEntityDTO.setChildren(getAuth(list.get(i).getId(), list));
                authEntities.add(authEntityDTO);
            }
        }
        return authEntities;
    }
}
