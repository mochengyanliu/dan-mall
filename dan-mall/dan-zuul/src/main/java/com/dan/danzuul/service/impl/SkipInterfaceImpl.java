package com.dan.danzuul.service.impl;

import com.dan.danzuul.entity.DictEntity;
import com.dan.danzuul.service.SkipInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author lijun
 * @Description 接口跳过实现类
 * @Date 2020-06-11 3:15 下午
 **/

@Log4j2
@Component
public class SkipInterfaceImpl implements SkipInterface {
    @Override
    public List<DictEntity> selectDictListByTypeId(Integer typeId) {
        log.error("过滤接口请求失败，参数：" + typeId);
        return null;
    }
}
