package com.dan.danbusiness.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author lijun
 * @Description
 * @Date 2020-08-17 2:49 下午
 **/

@Data
@ApiModel("商品对象")
public class ProductVO {
    @ApiModelProperty(required = false, notes = "商品id", example = "1")
    private Integer id;

    @ApiModelProperty(required = false, notes = "商品分类id", example = "1")
    private Integer productCategoryId;

    @ApiModelProperty(required = false, notes = "运费模版id", example = "1")
    private Integer feightTemplateId;

    @ApiModelProperty(required = false, notes = "商品类型id", example = "1")
    private Long productAttributeCategoryId;

    @ApiModelProperty(required = false, notes = "商品名称", example = "1")
    private String name;

    @ApiModelProperty(required = false, notes = "主图图片", example = "1")
    private String pic;

    @ApiModelProperty(required = false, notes = "货号", example = "1")
    private String productSn;

    @ApiModelProperty(required = false, notes = "删除状态", example = "1")
    private Integer deleteStatus;

    @ApiModelProperty(required = false, notes = "上架状态", example = "1")
    private Integer publishStatus;

    @ApiModelProperty(required = false, notes = "新品状态", example = "1")
    private Integer newStatus;

    @ApiModelProperty(required = false, notes = "推荐状态", example = "1")
    private Integer recommandStatus;

    @ApiModelProperty(required = false, notes = "排序", example = "1")
    private Integer sort;

    @ApiModelProperty(required = false, notes = "销量", example = "1")
    private Integer sale;

    @ApiModelProperty(required = false, notes = "价格", example = "1")
    private BigDecimal price;

    @ApiModelProperty(required = false, notes = "促销价格", example = "1")
    private BigDecimal promotionPrice;

    @ApiModelProperty(required = false, notes = "赠送的成长值", example = "1")
    private Integer giftGrowth;

    @ApiModelProperty(required = false, notes = "赠送的积分", example = "1")
    private Integer giftPoint;

    @ApiModelProperty(required = false, notes = "限制使用的积分数", example = "1")
    private Integer usePointLimit;

    @ApiModelProperty(required = false, notes = "副标题", example = "1")
    private String subTitle;

    @ApiModelProperty(required = false, notes = "市场价", example = "1")
    private BigDecimal originalPrice;

    @ApiModelProperty(required = false, notes = "库存", example = "1")
    private Integer stock;

    @ApiModelProperty(required = false, notes = "库存预警值", example = "1")
    private Integer lowStock;

    @ApiModelProperty(required = false, notes = "单位", example = "1")
    private String unit;

    @ApiModelProperty(required = false, notes = "商品重量", example = "1")
    private BigDecimal weight;

    @ApiModelProperty(required = false, notes = "是否为预告商品", example = "1")
    private Integer previewStatus;

    @ApiModelProperty(required = false, notes = "以逗号分割的产品服务", example = "1")
    private String serviceIds;

    @ApiModelProperty(required = false, notes = "关键字", example = "1")
    private String keywords;

    @ApiModelProperty(required = false, notes = "备注", example = "1")
    private String note;

    @ApiModelProperty(required = false, notes = "画册图片", example = "1")
    private Integer albumPics;

    @ApiModelProperty(required = false, notes = "详情标题", example = "1")
    private String detailTitle;

    @ApiModelProperty(required = false, notes = "促销开始时间", example = "1")
    private Date promotionStartTime;

    @ApiModelProperty(required = false, notes = "促销结束时间", example = "1")
    private Date promotionEndTime;

    @ApiModelProperty(required = false, notes = "活动限购数量", example = "1")
    private Integer promotionPerLimit;

    @ApiModelProperty(required = false, notes = "促销类型", example = "1")
    private Integer promotionType;

    @ApiModelProperty(required = false, notes = "产品分类名称", example = "1")
    private String productCategoryName;

    @ApiModelProperty(required = false, notes = "商品描述", example = "1")
    private String description;

    @ApiModelProperty(required = false, notes = "详情描述", example = "1")
    private String detailDesc;

    @ApiModelProperty(required = false, notes = "产品详情网页内容", example = "1")
    private String detailHtml;

    @ApiModelProperty(required = false, notes = "移动端网页详情", example = "1")
    private String detailMobileHtml;
}
