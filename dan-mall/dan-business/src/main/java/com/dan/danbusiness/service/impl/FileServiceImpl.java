package com.dan.danbusiness.service.impl;

import com.dan.danbusiness.entity.FileEntity;
import com.dan.danbusiness.mapper.FileEntityMapper;
import com.dan.danbusiness.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-06 1:23 下午
 **/

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileEntityMapper fileEntityMapper;

    @Override
    public int imageUpload(FileEntity fileEntity) {
        fileEntity.setCreateTime(new Date());
        return fileEntityMapper.insertSelective(fileEntity);
    }
}
