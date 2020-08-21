package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.MemberPriceEntity;

public interface MemberPriceEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberPriceEntity record);

    int insertSelective(MemberPriceEntity record);

    MemberPriceEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberPriceEntity record);

    int updateByPrimaryKey(MemberPriceEntity record);
}