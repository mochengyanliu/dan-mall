package com.dan.danauth.mapper;

import com.dan.danauth.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    UserEntity login(@Param("account") String account);

    int checkNameIsHas(String userName);

    String selectPasswordByUserId(Integer userId);

    int updatePasswordByUserId(@Param("userId") Integer userId, @Param("password") String password);

    UserEntity loginByPhone(@Param("phone") String phone);
}