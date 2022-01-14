package com.yisu.transaction.rocketmq.send.service;

import com.yisu.transacation.base.dao.model.FwTradeLog;

/**
 * @description 业务接口
 * @author xuyisu
 * @date '2020-03-25'
 */
public interface SendService {

    /**
     * 订单发货
     */
    void sendOrder(FwTradeLog fwTradeLog);

}
