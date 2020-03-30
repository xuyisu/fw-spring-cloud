package com.yisu.transaction.seata.at.send.service;

import com.yisu.transacation.base.dao.model.FwTradeLog;

/**
 * @description 商品表-业务接口
 * @author xuyisu
 * @date '2020-03-25'
 */
public interface SendService {

    /**
     * 支付订单
     */
    void sendOrder(FwTradeLog fwTradeLog);

}