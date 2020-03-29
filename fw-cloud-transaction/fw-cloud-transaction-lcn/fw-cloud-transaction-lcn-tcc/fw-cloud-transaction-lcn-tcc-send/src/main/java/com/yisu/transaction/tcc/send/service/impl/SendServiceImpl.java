package com.yisu.transaction.tcc.send.service.impl;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.yisu.transacation.base.dao.enums.StatusEnum;
import com.yisu.transacation.base.dao.model.FwTradeLog;
import com.yisu.transacation.base.dao.service.FwTradeLogService;
import com.yisu.transaction.tcc.send.service.SendService;
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

    @TccTransaction
    @Override
    public void sendOrder(FwTradeLog fwTradeLog) {
        fwTradeLog.setStatus(StatusEnum.THREE.getValue());
        fwTradeLog.setStatusDsc(StatusEnum.THREE.getDesc());
        fwTradeLogService.save(fwTradeLog);
        log.info("[订单状态{}]=>{},当前商品id=>{},商品名称=>{}",fwTradeLog.getOrderId(), StatusEnum.THREE.getDesc(),fwTradeLog.getProductId(),fwTradeLog.getProductName());
        hashMap.put(TracingContext.tracing().groupId(), fwTradeLog.getId());
    }

    public void confirmSendOrder(FwTradeLog fwTradeLog){
        log.info("当前产品{},事务执行成功",fwTradeLog.getProductName());
        hashMap.remove(TracingContext.tracing().groupId());
    }

    public void cancelSendOrder(FwTradeLog fwTradeLog){
        Long tradeLogId = hashMap.get(TracingContext.tracing().groupId());
        log.info("当前产品{},事务执行失败，回滚tradeLogId为{}的数据", fwTradeLog.getProductName(),tradeLogId);
        fwTradeLogService.removeById(tradeLogId);
        hashMap.remove(TracingContext.tracing().groupId());
    }
}