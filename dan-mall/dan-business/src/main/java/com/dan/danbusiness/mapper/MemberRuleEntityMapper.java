package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.MemberRuleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberRuleEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberRuleEntity record);

    int insertSelective(MemberRuleEntity record);

    MemberRuleEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberRuleEntity record);

    int updateByPrimaryKey(MemberRuleEntity record);
}