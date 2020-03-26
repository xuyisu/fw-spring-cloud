package com.yisu.transacation.base.dao.model;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.yisu.transacation.base.dao.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 订单记录表-实体
 * @author xuyisu
 * @date '2020-03-22'.
 */
@Data
@TableName("fw_trade_log")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class FwTradeLog extends Model<FwTradeLog> {

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
     * 订单状态 1.待支付 2.待发货 3.待收货 4.订单完成 5.订单关闭
     */
    private Integer status;
    /**
     * 状态描述
     */
    private String statusDsc;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 商品id
     */
    private Long productId;
    /**
     * 商品名称
     */
    private String productName;

    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单总额
     */
    private BigDecimal orderAmount;

    public FwTradeLog(StatusEnum status) {
        this.createTime = DateUtil.date();
        this.status = status.getValue();
        this.statusDsc=status.getDesc();
        this.orderAmount=new BigDecimal("100.00");
        this.userId=RandomUtil.randomLong(1000000);
        this.orderId= RandomUtil.randomLong(1000000);
    }
}
