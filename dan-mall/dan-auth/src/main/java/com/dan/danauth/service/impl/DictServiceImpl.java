package com.dan.danauth.service.impl;

import com.dan.danauth.entity.DictEntity;
import com.dan.danauth.mapper.DictEntityMapper;
import com.dan.danauth.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lijun
 * @Description 字典接口实现类
 * @Date 2020-06-15 1:47 下午
 **/

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictEntityMapper dictEntityMapper;

    @Override
    public List<DictEntity> selectDictListByTypeId(Integer type) {
        return dictEntityMapper.selectDictListByTypeId(type);
    }
}
