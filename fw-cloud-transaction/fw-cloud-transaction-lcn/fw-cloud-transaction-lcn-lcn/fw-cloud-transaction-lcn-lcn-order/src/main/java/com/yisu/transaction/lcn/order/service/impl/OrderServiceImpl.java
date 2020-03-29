package com.yisu.transaction.lcn.order.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.yisu.transacation.base.dao.enums.StatusEnum;
import com.yisu.transacation.base.dao.model.FwTradeLog;
import com.yisu.transacation.base.dao.service.FwTradeLogService;
import com.yisu.transaction.lcn.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @LcnTransaction
    @Override
    public void saveAndPayOrder(String productName) {

        FwTradeLog fwTradeLog =new FwTradeLog(StatusEnum.TWO);
        fwTradeLog.setProductId(System.currentTimeMillis());
        fwTradeLog.setProductName(productName);
        fwTradeLogService.save(fwTradeLog);
        log.info("[订单状态{}]=>{},当前商品id=>{},商品名称=>{}",fwTradeLog.getOrderId(), StatusEnum.TWO.getDesc(),fwTradeLog.getProductId(),fwTradeLog.getProductName());


    }

}