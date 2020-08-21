package com.dan.danbusiness.service.hystrix.impl;

import com.dan.danbusiness.service.hystrix.UserHystrixService;
import com.dan.danbusiness.vo.UserHystrixVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @Author lijun
 * @Description
 * @Date 2020-07-17 10:37 上午
 **/

@Log4j2
@Component
public class UserHystrixServiceImpl implements UserHystrixService {

    @Override
    public Integer insertUser(UserHystrixVO userHystrixVO) {
        log.error("用户新增请求权限系统失败，参数：" + userHystrixVO.toString());
        return null;
    }

    @Override
    public Integer updateUser(UserHystrixVO userHystrixVO) {
        log.error("用户修改请求权限系统失败，参数：" + userHystrixVO.toString());
        return null;
    }
}
