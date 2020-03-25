package com.yisu.transaction.rocketmq.product.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 商品表-实体
 * @author xuyisu
 * @date '2020-03-25 16:56:54'.
 */
@Data
@TableName("fw_product")
@EqualsAndHashCode(callSuper=false)
public class FwProduct extends Model<FwProduct> {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 商品分类id
     */
    private Long cateId;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 库存
     */
    private Long num;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 封面图
     */
    private String cover;
    /**
     * 图片集合
     */
    private String pics;
    /**
     * 是否促销
     */
    private int isSale;
    /**
     * 促销价格
     */
    private BigDecimal salePrice;
    /**
     * 是否热卖
     */
    private int isHot;
    /**
     * 是否上架
     */
    private int isOn;
    /**
     * 是否推荐
     */
    private int isTui;
}
