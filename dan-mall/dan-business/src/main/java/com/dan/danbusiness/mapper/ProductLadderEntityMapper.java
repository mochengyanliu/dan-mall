package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.ProductLadderEntity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductLadderEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductLadderEntity record);

    int insertSelective(ProductLadderEntity record);

    ProductLadderEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductLadderEntity record);

    int updateByPrimaryKey(ProductLadderEntity record);

    int insertArrayProductLadder(@Param("productLadderEntityList") List<ProductLadderEntity> productLadderEntityList);

    int deleteProductLadderByProductId(Integer productId);

}