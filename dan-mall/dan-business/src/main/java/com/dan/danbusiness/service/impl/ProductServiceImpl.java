package com.dan.danbusiness.service.impl;

import com.dan.danbusiness.entity.MemberPriceEntity;
import com.dan.danbusiness.entity.ProductEntity;
import com.dan.danbusiness.entity.ProductFullReductionEntity;
import com.dan.danbusiness.entity.ProductLadderEntity;
import com.dan.danbusiness.entity.SkuStockEntity;
import com.dan.danbusiness.enums.PromotionType;
import com.dan.danbusiness.mapper.MemberPriceEntityMapper;
import com.dan.danbusiness.mapper.ProductEntityMapper;
import com.dan.danbusiness.mapper.ProductFullReductionEntityMapper;
import com.dan.danbusiness.mapper.ProductLadderEntityMapper;
import com.dan.danbusiness.mapper.SkuStockEntityMapper;
import com.dan.danbusiness.mapper.SpecialPromotionEntityMapper;
import com.dan.danbusiness.service.ProductService;
import com.dan.danbusiness.vo.ProductPageVO;
import com.dan.danbusiness.vo.ProductVO;
import com.dan.dancommon.util.PageUtil;
import com.dan.dancommon.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-17 4:50 下午
 **/

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductEntityMapper productEntityMapper;

    @Autowired
    SpecialPromotionEntityMapper specialPromotionEntityMapper;

    @Autowired
    ProductFullReductionEntityMapper productFullReductionEntityMapper;

    @Autowired
    ProductLadderEntityMapper productLadderEntityMapper;

    @Autowired
    MemberPriceEntityMapper memberPriceEntityMapper;

    @Autowired
    SkuStockEntityMapper skuStockEntityMapper;

    @Override
    public int insertProduct(ProductVO productVO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductCategoryId(productVO.getProductCategoryId());
        productEntity.setProductAttributeCategoryId(productVO.getProductAttributeCategoryId());
        productEntity.setName(productVO.getName());
        productEntity.setPic(productVO.getPic());
        productEntity.setProductSn(productVO.getProductSn());
        productEntity.setDeleteStatus(0);
        productEntity.setPublishStatus(productVO.getPublishStatus());
        productEntity.setNewStatus(productVO.getNewStatus());
        productEntity.setRecommandStatus(productVO.getRecommandStatus());
        productEntity.setSort(productVO.getSort());
        productEntity.setSale(0);
        productEntity.setPrice(productVO.getPrice());
        productEntity.setGiftGrowth(productVO.getGiftGrowth());
        productEntity.setGiftPoint(productVO.getGiftPoint());
        productEntity.setUsePointLimit(productVO.getUsePointLimit());
        productEntity.setSubTitle(productVO.getSubTitle());
        productEntity.setDescription(productVO.getDescription());
        productEntity.setOriginalPrice(productVO.getOriginalPrice());
        Integer stock = 0;
        Integer lowStock = 0;

        // 根据sku计算库存和预警库存
        for (SkuStockEntity skuStockEntity : productVO.getSkuStockEntity()) {
            stock += skuStockEntity.getStock();
            lowStock += skuStockEntity.getLowStock();
        }
        productEntity.setStock(stock);
        productEntity.setLowStock(lowStock);
        productEntity.setUnit(productVO.getUnit());
        productEntity.setWeight(productVO.getWeight());
        productEntity.setPreviewStatus(productVO.getPreviewStatus());
        productEntity.setServiceIds(StringUtils.join(productVO.getServiceIds(), ','));
        productEntity.setKeywords(productVO.getKeywords());
        productEntity.setNote(productVO.getNote());
        productEntity.setAlbumPics(StringUtils.join(productVO.getAlbumPics(), ","));
        productEntity.setDetailTitle(productVO.getDetailTitle());
        productEntity.setDetailDesc(productVO.getDetailDesc());
        productEntity.setDetailHtml(productVO.getDetailHtml());
        productEntity.setDetailMobileHtml(productEntity.getDetailHtml());
        productEntity.setPromotionType(productVO.getPromotionType());
        productEntityMapper.insertSelective(productEntity);

        switch (productVO.getPromotionType()) {
            case PromotionType.NONE: // 没有促销
                break;
            case PromotionType.PROMOTION: // 促销
                productVO.getSpecialPromotionEntity().setProductId(productEntity.getId());
                specialPromotionEntityMapper.insertSelective(productVO.getSpecialPromotionEntity());
                break;
            case PromotionType.MEMBER: // 会员价
                for (MemberPriceEntity memberPriceEntity : productVO.getMemberPriceEntity()) {
                    memberPriceEntity.setProductId(productEntity.getId());
                }
                memberPriceEntityMapper.insertArrayMemberPrice(productVO.getMemberPriceEntity());
                break;
            case PromotionType.LADDER: // 阶梯价
                for (ProductLadderEntity productLadderEntity : productVO.getProductLadderEntity()) {
                    productLadderEntity.setProductId(productEntity.getId());
                }
                productLadderEntityMapper.insertArrayProductLadder(productVO.getProductLadderEntity());
                break;
            case PromotionType.FULLCATEGORY: // 满减价
                for (ProductFullReductionEntity productFullReductionEntity : productVO.getProductFullReductionEntity()) {
                    productFullReductionEntity.setProductId(productEntity.getId());
                }
                productFullReductionEntityMapper.insertArrayProductFullReduction(productVO.getProductFullReductionEntity());
                break;
            default:
                break;
        }

        // 保存sku
        for (SkuStockEntity skuStockEntity : productVO.getSkuStockEntity()) {
            skuStockEntity.setProductId(productEntity.getId());
            skuStockEntity.setSale(0);
        }
        skuStockEntityMapper.insertArraySkuStock(productVO.getSkuStockEntity());

        return 1;
    }

    @Override
    public int updateProduct(ProductVO productVO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductCategoryId(productVO.getProductCategoryId());
        productEntity.setProductAttributeCategoryId(productVO.getProductAttributeCategoryId());
        productEntity.setName(productVO.getName());
        productEntity.setPic(productVO.getPic());
        productEntity.setProductSn(productVO.getProductSn());
        productEntity.setDeleteStatus(0);
        productEntity.setPublishStatus(productVO.getPublishStatus());
        productEntity.setNewStatus(productVO.getNewStatus());
        productEntity.setRecommandStatus(productVO.getRecommandStatus());
        productEntity.setSort(productVO.getSort());
        productEntity.setSale(0);
        productEntity.setPrice(productVO.getPrice());
        productEntity.setGiftGrowth(productVO.getGiftGrowth());
        productEntity.setGiftPoint(productVO.getGiftPoint());
        productEntity.setUsePointLimit(productVO.getUsePointLimit());
        productEntity.setSubTitle(productVO.getSubTitle());
        productEntity.setDescription(productVO.getDescription());
        productEntity.setOriginalPrice(productVO.getOriginalPrice());
        Integer stock = 0;
        Integer lowStock = 0;

        // 根据sku计算库存和预警库存
        for (SkuStockEntity skuStockEntity : productVO.getSkuStockEntity()) {
            stock += skuStockEntity.getStock();
            lowStock += skuStockEntity.getLowStock();
        }
        productEntity.setStock(stock);
        productEntity.setLowStock(lowStock);
        productEntity.setUnit(productVO.getUnit());
        productEntity.setWeight(productVO.getWeight());
        productEntity.setPreviewStatus(productVO.getPreviewStatus());
        productEntity.setServiceIds(StringUtils.join(productVO.getServiceIds(), ','));
        productEntity.setKeywords(productVO.getKeywords());
        productEntity.setNote(productVO.getNote());
        productEntity.setAlbumPics(StringUtils.join(productVO.getAlbumPics(), ","));
        productEntity.setDetailTitle(productVO.getDetailTitle());
        productEntity.setDetailDesc(productVO.getDetailDesc());
        productEntity.setDetailHtml(productVO.getDetailHtml());
        productEntity.setDetailMobileHtml(productEntity.getDetailHtml());
        productEntity.setPromotionType(productVO.getPromotionType());

        // 修改前先删除原来的信息
        Integer promotionType = productEntityMapper.selectPromotionTypeById(productVO.getId());
        switch (promotionType) {
            case PromotionType.NONE: // 没有促销
                break;
            case PromotionType.PROMOTION: // 促销
                specialPromotionEntityMapper.deleteSpecialPromotionByProductId(productVO.getId());
                break;
            case PromotionType.MEMBER: // 会员价
                memberPriceEntityMapper.deleteMemberPriceByProductId(productVO.getId());
                break;
            case PromotionType.LADDER: // 阶梯价
                productLadderEntityMapper.deleteProductLadderByProductId(productVO.getId());
                break;
            case PromotionType.FULLCATEGORY: // 满减价
                productFullReductionEntityMapper.deleteProductFullReductionByProductId(productVO.getId());
                break;
            default:
                break;
        }
        productEntityMapper.updateByPrimaryKey(productEntity);

        switch (productVO.getPromotionType()) {
            case PromotionType.NONE: // 没有促销
                break;
            case PromotionType.PROMOTION: // 促销
                productVO.getSpecialPromotionEntity().setProductId(productEntity.getId());
                specialPromotionEntityMapper.insertSelective(productVO.getSpecialPromotionEntity());
                break;
            case PromotionType.MEMBER: // 会员价
                for (MemberPriceEntity memberPriceEntity : productVO.getMemberPriceEntity()) {
                    memberPriceEntity.setProductId(productEntity.getId());
                }
                memberPriceEntityMapper.insertArrayMemberPrice(productVO.getMemberPriceEntity());
                break;
            case PromotionType.LADDER: // 阶梯价
                for (ProductLadderEntity productLadderEntity : productVO.getProductLadderEntity()) {
                    productLadderEntity.setProductId(productEntity.getId());
                }
                productLadderEntityMapper.insertArrayProductLadder(productVO.getProductLadderEntity());
                break;
            case PromotionType.FULLCATEGORY: // 满减价
                for (ProductFullReductionEntity productFullReductionEntity : productVO.getProductFullReductionEntity()) {
                    productFullReductionEntity.setProductId(productEntity.getId());
                }
                productFullReductionEntityMapper.insertArrayProductFullReduction(productVO.getProductFullReductionEntity());
                break;
            default:
                break;
        }

        // 保存sku
        skuStockEntityMapper.deleteSkuStockByProductId(productVO.getId());
        for (SkuStockEntity skuStockEntity : productVO.getSkuStockEntity()) {
            skuStockEntity.setProductId(productEntity.getId());
            skuStockEntity.setSale(0);
        }
        skuStockEntityMapper.insertArraySkuStock(productVO.getSkuStockEntity());

        return 1;
    }

    @Override
    public Map<String, Object> selectProductList(ProductPageVO productPageVO) {
        Map<String, Object> map = new HashMap<>();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNumber(productPageVO.getPageNumber());
        pageUtil.setTotalNumber(productEntityMapper.selectProductListCount(productPageVO));
        pageUtil.setCurrentPage(productPageVO.getCurrentPage());
        productPageVO.setDbIndex(pageUtil.getDbIndex());
        productPageVO.setDbNumber(pageUtil.getDbNumber());
        List<ProductEntity> productEntities = productEntityMapper.selectProductList(productPageVO);
        map.put("pageUtil", pageUtil);
        map.put("productEntities", productEntities);
        return map;
    }

    @Override
    public int deleteProduct(String ids) {
        if (StringUtil.isEmpty(ids, true)) {
            return -1;
        }
        List<String> list = Arrays.asList(ids.split(","));
        return productEntityMapper.deleteByPrimaryKeys(list);
    }
}
