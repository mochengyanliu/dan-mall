package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.ProductEntity;
import com.dan.danbusiness.vo.ProductPageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductEntity productEntity);

    int insertSelective(ProductEntity productEntity);

    ProductEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductEntity productEntity);

    int updateByPrimaryKeyWithBLOBs(ProductEntity productEntity);

    int updateByPrimaryKey(ProductEntity productEntity);

    int selectProductListCount(@Param("productPageVO") ProductPageVO productPageVO);

    List<ProductEntity> selectProductList(@Param("productPageVO") ProductPageVO productPageVO);

    Integer selectPromotionTypeById(Integer id);

    int deleteByPrimaryKeys(@Param("ids") List<String> ids);
}