package com.dan.danzuul.service;

import com.dan.danzuul.entity.DictEntity;
import com.dan.danzuul.service.impl.SkipInterfaceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author lijun
 * @Description  接口跳过类
 * @Date 2020-06-11 3:15 下午
 **/

@FeignClient(value = "dan-auth", fallback = SkipInterfaceImpl.class)
public interface SkipInterface {
    @RequestMapping(value = "dict/selectDictListByTypeId", method = RequestMethod.POST, consumes = "application/json")
    List<DictEntity> selectDictListByTypeId(@RequestParam(value = "typeId") Integer typeId);
}
