package com.yisu.transaction.txc.order.service;

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

}