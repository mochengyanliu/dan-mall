package com.dan.danauth.service;

import com.dan.dancommon.base.BaseResponseModel;

/**
 * @Author lijun
 * @Description
 * @Date 2020-06-16 5:21 下午
 **/

public interface LoginService {

    BaseResponseModel<Object> login(String account, String password, String code, String pCode);

    BaseResponseModel<Object> loginByPhone(String phone, String code, String pCode);

    int checkPhone(String phone);
}
