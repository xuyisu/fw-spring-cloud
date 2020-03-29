package com.yisu.transaction.tcc.order.service.impl;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.yisu.transacation.base.dao.enums.StatusEnum;
import com.yisu.transacation.base.dao.model.FwTradeLog;
import com.yisu.transacation.base.dao.service.FwTradeLogService;
import com.yisu.transaction.tcc.order.feign.RemoteSendServiceFeign;
import com.yisu.transaction.tcc.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description 订单记录表-业务实现
 * @author xuyisu
 * @date '2020-03-22'
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private FwTradeLogService fwTradeLogService;

    @Autowired
    private RemoteSendServiceFeign remoteSendServiceFeign;

    ConcurrentHashMap<String, Long> hashMap = new ConcurrentHashMap<>();

    @TccTransaction
    @Override
    public void saveAndPayOrder(String productName) {

        FwTradeLog fwTradeLog =new FwTradeLog(StatusEnum.TWO);
        fwTradeLog.setProductId(System.currentTimeMillis());
        fwTradeLog.setProductName(productName);
        fwTradeLogService.save(fwTradeLog);
        log.info("[订单状态{}]=>{},当前商品id=>{},商品名称=>{}",fwTradeLog.getOrderId(), StatusEnum.TWO.getDesc(),fwTradeLog.getProductId(),fwTradeLog.getProductName());

        remoteSendServiceFeign.sendOrder(fwTradeLog);
        hashMap.put(TracingContext.tracing().groupId(), fwTradeLog.getId());
//        int i=1/0;
    }

    public void confirmSaveAndPayOrder(String productName){
        log.info("当前产品{},事务执行成功",productName);
        hashMap.remove(TracingContext.tracing().groupId());
    }

    public void cancelSaveAndPayOrder(String productName){
        Long tradeLogId = hashMap.get(TracingContext.tracing().groupId());
        log.info("当前产品{},事务执行失败，回滚tradeLogId为{}的数据", productName,tradeLogId);
        fwTradeLogService.removeById(tradeLogId);
        hashMap.remove(TracingContext.tracing().groupId());
    }


}