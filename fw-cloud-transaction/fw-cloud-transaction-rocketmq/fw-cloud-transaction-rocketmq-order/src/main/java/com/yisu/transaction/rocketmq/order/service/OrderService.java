package com.yisu.transaction.rocketmq.order.service;

import com.yisu.transacation.base.dao.model.FwTradeLog;

/**
 * @description 订单记录表-业务接口
 * @author xuyisu
 * @date '2020-03-22'
 */
public interface OrderService{

    /**
     * 下单
     */
    void saveAndPayOrder(String productName);

    /**
     * 支付
     */
    void payOrder(FwTradeLog fwTradeLog,String transactionId);
}