package com.dan.danbusiness.service;

import com.dan.danbusiness.entity.MemberLevelEntity;
import com.dan.danbusiness.vo.PageVO;

import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-17 8:07 下午
 **/

public interface MemberService {

    int insertMemberLevel(MemberLevelEntity memberLevelEntity);

    int updateMemberLevel(MemberLevelEntity memberLevelEntity);

    Map<String, Object> selectMemberLevelList(PageVO pageVO);

    List<MemberLevelEntity> selectAllMemberLevel();

    int deleteMemberLevel(String ids);
}
