package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.MemberLevelEntity;
import com.dan.danbusiness.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberLevelEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberLevelEntity record);

    int insertSelective(MemberLevelEntity record);

    MemberLevelEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberLevelEntity record);

    int updateByPrimaryKey(MemberLevelEntity record);

    int checkNameRepeat(@Param("name") String name, @Param("id") Integer id);

    int selectMemberLevelListCount(@Param("pageVO") PageVO pageVO);

    List<MemberLevelEntity> selectMemberLevelList(@Param("pageVO") PageVO pageVO);

    List<MemberLevelEntity> selectAllMemberLevel();

    int deleteMemberLevelByIds(@Param("ids") List<String> ids);
}