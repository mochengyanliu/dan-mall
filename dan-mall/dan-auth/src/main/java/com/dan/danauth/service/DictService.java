package com.dan.danauth.service;

import com.dan.danauth.entity.DictEntity;

import java.util.List;

/**
 * @Author lijun
 * @Description 字典接口类
 * @Date 2020-06-15 1:06 下午
 **/

public interface DictService {
    List<DictEntity> selectDictListByTypeId(Integer type);
}
