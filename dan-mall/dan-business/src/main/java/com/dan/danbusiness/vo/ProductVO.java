package com.dan.danbusiness.vo;

import com.dan.danbusiness.entity.MemberPriceEntity;
import com.dan.danbusiness.entity.ProductFullReductionEntity;
import com.dan.danbusiness.entity.ProductLadderEntity;
import com.dan.danbusiness.entity.SkuStockEntity;
import com.dan.danbusiness.entity.SpecialPromotionEntity;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-17 2:49 下午
 **/

@Data
@ApiModel("商品对象")
public class ProductVO {
    @ApiModelProperty(notes = "商品id")
    private Integer id;

    @ApiModelProperty(notes = "商品分类id")
    private Integer productCategoryId;

    @ApiModelProperty(notes = "运费模版id")
    private Integer feightTemplateId;

    @ApiModelProperty(notes = "商品类型id")
    private Long productAttributeCategoryId;

    @ApiModelProperty(notes = "商品名称")
    private String name;

    @ApiModelProperty(notes = "主图图片")
    private String pic;

    @ApiModelProperty(notes = "货号")
    private String productSn;

    @ApiModelProperty(notes = "上架状态")
    private Integer publishStatus;

    @ApiModelProperty(notes = "新品状态")
    private Integer newStatus;

    @ApiModelProperty(notes = "推荐状态")
    private Integer recommandStatus;

    @ApiModelProperty(notes = "排序")
    private Integer sort;

    @ApiModelProperty(notes = "价格")
    private BigDecimal price;

    @ApiModelProperty(notes = "赠送的成长值")
    private Integer giftGrowth;

    @ApiModelProperty(notes = "赠送的积分")
    private Integer giftPoint;

    @ApiModelProperty(notes = "限制使用的积分数")
    private Integer usePointLimit;

    @ApiModelProperty(notes = "副标题")
    private String subTitle;

    @ApiModelProperty(notes = "市场价")
    private BigDecimal originalPrice;

    @ApiModelProperty(notes = "单位")
    private String unit;

    @ApiModelProperty(notes = "商品重量")
    private BigDecimal weight;

    @ApiModelProperty(notes = "是否为预告商品")
    private Integer previewStatus;

    @ApiModelProperty(notes = "产品服务")
    private String[] serviceIds;

    @ApiModelProperty(notes = "关键字")
    private String keywords;

    @ApiModelProperty(notes = "备注")
    private String note;

    @ApiModelProperty(notes = "画册图片")
    private String[] albumPics;

    @ApiModelProperty(notes = "详情标题")
    private String detailTitle;

    @ApiModelProperty(notes = "促销类型")
    private Integer promotionType;

    @ApiModelProperty(notes = "商品描述")
    private String description;

    @ApiModelProperty(notes = "详情描述")
    private String detailDesc;

    @ApiModelProperty(notes = "产品详情网页内容")
    private String detailHtml;

    @ApiModelProperty(notes = "移动端网页详情")
    private String detailMobileHtml;

    @ApiModelProperty(notes = "特惠促销对象")
    private SpecialPromotionEntity specialPromotionEntity;

    @ApiModelProperty(notes = "会员价格对象")
    private List<MemberPriceEntity> memberPriceEntity;

    @ApiModelProperty(notes = "商品阶梯价格对象")
    private List<ProductLadderEntity> productLadderEntity;

    @ApiModelProperty(notes = "商品满减对象")
    private List<ProductFullReductionEntity> productFullReductionEntity;

    @ApiModelProperty(notes = "商品SKU对象")
    private List<SkuStockEntity> skuStockEntity;
}
