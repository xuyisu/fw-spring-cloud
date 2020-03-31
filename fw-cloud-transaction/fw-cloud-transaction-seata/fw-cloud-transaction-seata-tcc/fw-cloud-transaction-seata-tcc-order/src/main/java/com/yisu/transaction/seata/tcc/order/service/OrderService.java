package com.yisu.transaction.seata.tcc.order.service;

import io.seata.rm.tcc.api.LocalTCC;

/**
 * @description 订单记录表-业务接口
 * @author xuyisu
 * @date '2020-03-22'
 */
@LocalTCC
public interface OrderService{

    /**
     * 下单
     */
    void saveAndPayOrder(String productName);

}