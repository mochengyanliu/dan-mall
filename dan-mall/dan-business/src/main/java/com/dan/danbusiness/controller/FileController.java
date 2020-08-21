package com.dan.danbusiness.controller;

import com.alibaba.fastjson.JSON;
import com.dan.danbusiness.entity.FileEntity;
import com.dan.danbusiness.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-06 10:01 上午
 **/

@Log4j2
@RestController
@RequestMapping("/file")
@Api(tags = "文件管理模块")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "文件上传", notes = "")
    public String upload(MultipartFile file) {

        log.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(file) || file.isEmpty()) {
            log.error("文件为空");
            return "文件为空，请重新上传";
        }

        try {
            //根据相对获取绝对路径(文件上传到的保存位置)
            String realPath = "/Users/lijun/apache-tomcat-9.0.31/temp/file/";
            //获取文件后缀
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            //文件名我这里使用UUID和时间组成的
            String newFileNamePrefix= UUID.randomUUID().toString().replace("-","")+
                    new SimpleDateFormat("yyyyMMddHHssSSS").format(new Date());
            String newFileName=newFileNamePrefix+"."+extension;
            //处理文件上传
            file.transferTo(new File(realPath,newFileName));
            log.debug("文件写入成功...");
            FileEntity fileEntity = new FileEntity();
            fileEntity.setName(newFileName);
            fileEntity.setPath(realPath + newFileName);
            fileEntity.setSize(file.getSize());
            fileEntity.setStatus(1);
            fileEntity.setType(1);
            fileEntity.setCreateTime(new Date());
            fileService.imageUpload(fileEntity);
            return newFileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }

}
