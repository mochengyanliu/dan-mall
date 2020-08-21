package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.UserStatisticsInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserStatisticsInfoEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserStatisticsInfoEntity record);

    int insertSelective(UserStatisticsInfoEntity record);

    UserStatisticsInfoEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserStatisticsInfoEntity record);

    int updateByPrimaryKey(UserStatisticsInfoEntity record);
}