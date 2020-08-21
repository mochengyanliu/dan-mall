package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.ReceiveAddressEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReceiveAddressEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceiveAddressEntity record);

    int insertSelective(ReceiveAddressEntity record);

    ReceiveAddressEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReceiveAddressEntity record);

    int updateByPrimaryKey(ReceiveAddressEntity record);
}