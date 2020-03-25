package com.yisu.transaction.rocketmq.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 订单表-实体
 * @author xuyisu
 * @date '2020-03-22 15:40:44'.
 */
@Data
@TableName("fw_order")
@EqualsAndHashCode(callSuper=false)
public class FwOrder  extends Model<FwOrder> {

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
     * 下单人id
     */
    private Long userId;
    /**
     * 请鞋上代码注释
     */
    private BigDecimal amount;
    /**
     * 订单状态 1.待支付 2.待发货 3.待收货 4.订单完成 5.订单关闭
     */
    private Integer status;
    /**
     * 收货地址
     */
    private Long addressId;
    /**
     * 快递id
     */
    private Integer expressId;
    /**
     * 快递单号
     */
    private String expressNo;
    /**
     * 支付交易号
     */
    private String tradeNo;
    /**
     * 支付信息
     */
    private String tradeExt;
}