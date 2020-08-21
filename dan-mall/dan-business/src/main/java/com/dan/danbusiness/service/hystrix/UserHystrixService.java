package com.dan.danbusiness.service.hystrix;

import com.dan.danbusiness.service.hystrix.impl.UserHystrixServiceImpl;
import com.dan.danbusiness.vo.UserHystrixVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author lijun
 * @Description
 * @Date 2020-07-17 10:36 上午
 **/

@FeignClient(value = "dan-auth", fallback = UserHystrixServiceImpl.class)
public interface UserHystrixService {

    @RequestMapping(value = "user/insertUser", method = RequestMethod.POST, consumes = "application/json")
    Integer insertUser(@RequestBody UserHystrixVO userHystrixVO);

    @RequestMapping(value = "user/updateUser", method = RequestMethod.POST, consumes = "application/json")
    Integer updateUser(@RequestBody UserHystrixVO userHystrixVO);
}
