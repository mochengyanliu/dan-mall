package com.dan.danbusiness.service.impl;

import com.dan.danbusiness.entity.MemberLevelEntity;
import com.dan.danbusiness.mapper.MemberLevelEntityMapper;
import com.dan.danbusiness.service.MemberService;
import com.dan.danbusiness.vo.PageVO;
import com.dan.dancommon.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-17 8:07 下午
 **/

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberLevelEntityMapper memberLevelEntityMapper;

    @Override
    public int insertMemberLevel(MemberLevelEntity memberLevelEntity) {
        int count = memberLevelEntityMapper.checkNameRepeat(memberLevelEntity.getName(), null);
        if (count > 0){
            return -1;
        }
        return memberLevelEntityMapper.insertSelective(memberLevelEntity);
    }

    @Override
    public int updateMemberLevel(MemberLevelEntity memberLevelEntity) {
        int count = memberLevelEntityMapper.checkNameRepeat(memberLevelEntity.getName(), memberLevelEntity.getId());
        if (count > 0){
            return -1;
        }
        return memberLevelEntityMapper.updateByPrimaryKey(memberLevelEntity);
    }

    @Override
    public Map<String, Object> selectMemberLevelList(PageVO pageVO) {
        Map<String, Object> map = new HashMap<>();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNumber(pageVO.getPageNumber());
        pageUtil.setTotalNumber(memberLevelEntityMapper.selectMemberLevelListCount(pageVO));
        pageUtil.setCurrentPage(pageVO.getCurrentPage());
        pageVO.setDbIndex(pageUtil.getDbIndex());
        pageVO.setDbNumber(pageUtil.getDbNumber());
        List<MemberLevelEntity> memberLevelEntities = memberLevelEntityMapper.selectMemberLevelList(pageVO);
        map.put("pageUtil", pageUtil);
        map.put("memberLevelEntities", memberLevelEntities);
        return map;
    }

    @Override
    public List<MemberLevelEntity> selectAllMemberLevel() {
        return memberLevelEntityMapper.selectAllMemberLevel();
    }

    @Override
    public int deleteMemberLevel(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        return memberLevelEntityMapper.deleteMemberLevelByIds(list);
    }
}
