package com.dan.danauth.mapper;

import com.dan.danauth.entity.LoginLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginLogEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginLogEntity record);

    int insertSelective(LoginLogEntity record);

    LoginLogEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginLogEntity record);

    int updateByPrimaryKey(LoginLogEntity record);
}