package com.dan.danbusiness.mapper;

import com.dan.danbusiness.entity.ProductAttributeCategoryEntity;
import com.dan.danbusiness.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductAttributeCategoryEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductAttributeCategoryEntity record);

    int insertSelective(ProductAttributeCategoryEntity record);

    ProductAttributeCategoryEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductAttributeCategoryEntity record);

    int updateByPrimaryKey(ProductAttributeCategoryEntity record);

    int checkproductAttributeCategoryName(@Param("name") String name, @Param("id") Integer id);

    int selectProductAttributeCategoryListCount();

    List<ProductAttributeCategoryEntity> selectProductAttributeCategoryList(@Param("pageVO")PageVO pageVO);

    List<ProductAttributeCategoryEntity> selectAllProductAttributeCategory();

    int deleteByPrimaryKeys(@Param("ids") List<String> ids);

    int updateAttributeCountOrParamCountByType(@Param("type") Integer type,@Param("id") Integer id,@Param("count") Integer count);
}