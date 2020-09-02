package com.dan.danbusiness.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductEntity {

    @ApiModelProperty(notes = "商品ID")
    private Integer id;

    @ApiModelProperty(notes = "商品分类ID")
    private Integer productCategoryId;

    @ApiModelProperty(notes = "运费模版ID")
    private Integer feightTemplateId;

    @ApiModelProperty(notes = "品牌属性分类ID")
    private Long productAttributeCategoryId;

    @ApiModelProperty(notes = "商品名称")
    private String name;

    @ApiModelProperty(notes = "主图图片")
    private String pic;

    @ApiModelProperty(notes = "货号")
    private String productSn;

    @ApiModelProperty(notes = "删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;

    @ApiModelProperty(notes = "上架状态：0->下架；1->上架")
    private Integer publishStatus;

    @ApiModelProperty(notes = "新品状态:0->不是新品；1->新品")
    private Integer newStatus;

    @ApiModelProperty(notes = "推荐状态；0->不推荐；1->推荐")
    private Integer recommandStatus;

    @ApiModelProperty(notes = "排序")
    private Integer sort;

    @ApiModelProperty(notes = "销量")
    private Integer sale;

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

    @ApiModelProperty(notes = "商品描述")
    private BigDecimal originalPrice;

    @ApiModelProperty(notes = "库存")
    private Integer stock;

    @ApiModelProperty(notes = "库存预警值")
    private Integer lowStock;

    @ApiModelProperty(notes = "单位")
    private String unit;

    @ApiModelProperty(notes = "商品重量，默认为克")
    private BigDecimal weight;

    @ApiModelProperty(notes = "是否为预告商品：0->不是；1->是")
    private Integer previewStatus;

    @ApiModelProperty(notes = "以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮")
    private String serviceIds;

    @ApiModelProperty(notes = "关键字")
    private String keywords;

    @ApiModelProperty(notes = "备注")
    private String note;

    @ApiModelProperty(notes = "画册图片，连产品图片限制为5张，以逗号分割")
    private String albumPics;

    @ApiModelProperty(notes = "详情标题")
    private String detailTitle;

    @ApiModelProperty(notes = "促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购")
    private Integer promotionType;

    @ApiModelProperty(notes = "产品分类名称")
    private String productCategoryName;

    @ApiModelProperty(notes = "商品描述")
    private String description;

    @ApiModelProperty(notes = "详情描述")
    private String detailDesc;

    @ApiModelProperty(notes = "产品详情网页内容")
    private String detailHtml;

    @ApiModelProperty(notes = "移动端网页详情")
    private String detailMobileHtml;
}