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
 * @description 订单详情表-实体
 * @author xuyisu
 * @date '2020-03-22 15:51:18'.
 */
@Data
@TableName("fw_order")
@EqualsAndHashCode(callSuper=false)
public class FwOrderDetail extends Model<FwOrder> {

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
     * 订单id
     */
    private Long orderId;
    /**
     * 商品id
     */
    private Long productId;
    /**
     * 请鞋上代码注释
     */
    private BigDecimal price;
    /**
     * 商品数量
     */
    private Integer productNum;
}
