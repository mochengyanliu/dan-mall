package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.SpecialPromotionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SpecialPromotionEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpecialPromotionEntity record);

    int insertSelective(SpecialPromotionEntity record);

    SpecialPromotionEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpecialPromotionEntity record);

    int updateByPrimaryKey(SpecialPromotionEntity record);
}