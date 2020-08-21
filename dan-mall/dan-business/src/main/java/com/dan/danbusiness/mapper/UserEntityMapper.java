package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.UserEntity;
import com.dan.danbusiness.vo.UserPageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    int selectUserListCount(@Param("userPageVo") UserPageVo userPageVo);

    List<UserEntity> selectUserList(@Param("userPageVo") UserPageVo userPageVo);

    int checkAccountRepeat(@Param("account") String account, @Param("id") Integer id);

    int checkPhoneRepeat(@Param("phone") String phone, @Param("id") Integer id);
}