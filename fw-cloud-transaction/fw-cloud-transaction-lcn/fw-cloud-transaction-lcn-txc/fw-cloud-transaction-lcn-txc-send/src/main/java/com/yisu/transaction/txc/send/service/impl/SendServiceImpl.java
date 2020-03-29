package com.yisu.transaction.txc.send.service.impl;

import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.yisu.transacation.base.dao.enums.StatusEnum;
import com.yisu.transacation.base.dao.model.FwTradeLog;
import com.yisu.transacation.base.dao.service.FwTradeLogService;
import com.yisu.transaction.txc.send.service.SendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description 商品表-业务实现
 * @author xuyisu
 * @date '2020-03-25'
 */
@Service
@Slf4j
public class SendServiceImpl implements SendService {

    @Autowired
    private FwTradeLogService fwTradeLogService;

    ConcurrentHashMap<String, Long> hashMap = new ConcurrentHashMap<>();

    @TxcTransaction(timeout = 2000)
    @Override
    public void sendOrder(FwTradeLog fwTradeLog) {
        fwTradeLog.setStatus(StatusEnum.THREE.getValue());
        fwTradeLog.setStatusDsc(StatusEnum.THREE.getDesc());
        fwTradeLogService.save(fwTradeLog);
        log.info("[订单状态{}]=>{},当前商品id=>{},商品名称=>{}",fwTradeLog.getOrderId(), StatusEnum.THREE.getDesc(),fwTradeLog.getProductId(),fwTradeLog.getProductName());
        hashMap.put(TracingContext.tracing().groupId(), fwTradeLog.getId());
    }
}