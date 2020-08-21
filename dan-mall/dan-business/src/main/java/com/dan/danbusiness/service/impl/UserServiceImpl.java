package com.dan.danbusiness.service.impl;

import com.dan.danbusiness.entity.UserEntity;
import com.dan.danbusiness.mapper.UserEntityMapper;
import com.dan.danbusiness.service.UserService;
import com.dan.danbusiness.service.hystrix.UserHystrixService;
import com.dan.danbusiness.vo.UserHystrixVO;
import com.dan.danbusiness.vo.UserPageVo;
import com.dan.dancommon.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description 用户接口实现类
 * @Date 2020-06-23 2:42 下午
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityMapper userEntityMapper;

    @Autowired
    UserHystrixService userHystrixService;

    @Override
    public int registerUser(UserEntity userEntity) {
        // 校验账号是否重复
        int count = userEntityMapper.checkAccountRepeat(userEntity.getAccount(), null);
        if (count > 0) {
            return -1;
        }

        // 校验手机号是否重复
        count = userEntityMapper.checkPhoneRepeat(userEntity.getPhone(), null);
        if (count > 0) {
            return -2;
        }
        // 新增权限系统用户
        UserHystrixVO userHystrixVO = new UserHystrixVO();
        userHystrixVO.setUserName(userEntity.getUserName());
        userHystrixVO.setAccount(userEntity.getAccount());
        userHystrixVO.setPhone(userEntity.getPhone());
        userHystrixVO.setStatus(userEntity.getStatus());
        userHystrixVO.setRoleId(userEntity.getType());
        userHystrixVO.setCreateUserId(userEntity.getCreateUser());
        count = userHystrixService.insertUser(userHystrixVO);
        if (count > 0) {
            // 新增用户
            userEntity.setId(count);
            userEntity.setCreateTime(new Date());
            return userEntityMapper.insertSelective(userEntity);
        }
        return count;
    }

    @Override
    public Map<String, Object> selectUserList(UserPageVo userPageVo) {
        Map<String, Object> map = new HashMap<>();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNumber(userPageVo.getPageNumber());
        pageUtil.setTotalNumber(userEntityMapper.selectUserListCount(userPageVo));
        pageUtil.setCurrentPage(userPageVo.getCurrentPage());
        userPageVo.setDbIndex(pageUtil.getDbIndex());
        userPageVo.setDbNumber(pageUtil.getDbNumber());
        List<UserEntity> userEntities = userEntityMapper.selectUserList(userPageVo);
        map.put("pageUtil", pageUtil);
        map.put("userEntities", userEntities);
        return map;
    }

    @Override
    public int updateUser(UserEntity userEntity) {
        // 校验账号是否重复
        int count = userEntityMapper.checkAccountRepeat(userEntity.getAccount(), userEntity.getId());
        if (count > 0) {
            return -1;
        }

        // 校验手机号是否重复
        count = userEntityMapper.checkPhoneRepeat(userEntity.getPhone(), userEntity.getId());
        if (count > 0) {
            return -2;
        }
        // 新增权限系统用户
        UserHystrixVO userHystrixVO = new UserHystrixVO();
        userHystrixVO.setId(userEntity.getId());
        userHystrixVO.setUserName(userEntity.getUserName());
        userHystrixVO.setAccount(userEntity.getAccount());
        userHystrixVO.setPhone(userEntity.getPhone());
        userHystrixVO.setStatus(userEntity.getStatus());
        userHystrixVO.setRoleId(userEntity.getType());
        userHystrixVO.setCreateUserId(userEntity.getCreateUser());
        count = userHystrixService.updateUser(userHystrixVO);
        if (count > 0) {
            // 修改用户用户
            userEntity.setUpdateTime(new Date());
            return userEntityMapper.updateByPrimaryKeySelective(userEntity);
        }
        return count;
    }
}
