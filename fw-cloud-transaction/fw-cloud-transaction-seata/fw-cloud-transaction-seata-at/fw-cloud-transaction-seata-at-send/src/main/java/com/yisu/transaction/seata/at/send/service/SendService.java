package com.yisu.transaction.seata.tcc.send.service;

import com.yisu.transacation.base.dao.model.FwTradeLog;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

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