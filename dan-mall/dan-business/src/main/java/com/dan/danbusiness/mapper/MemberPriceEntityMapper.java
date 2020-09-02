package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.MemberPriceEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberPriceEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberPriceEntity record);

    int insertSelective(MemberPriceEntity record);

    MemberPriceEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberPriceEntity record);

    int updateByPrimaryKey(MemberPriceEntity record);

    int insertArrayMemberPrice(@Param("memberPriceEntityList") List<MemberPriceEntity> memberPriceEntityList);

    int deleteMemberPriceByProductId(Integer productId);
}