package com.yisu.transaction.rocketmq.order.service.impl;

import com.yisu.transacation.base.dao.enums.StatusEnum;
import com.yisu.transacation.base.dao.model.FwTradeLog;
import com.yisu.transacation.base.dao.model.FwTransactionLog;
import com.yisu.transacation.base.dao.service.FwTradeLogService;
import com.yisu.transacation.base.dao.service.FwTransactionLogService;
import com.yisu.transaction.rocketmq.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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
    private FwTransactionLogService fwTransactionLogService;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Override
    public void saveAndPayOrder(String productName) {

        FwTradeLog fwTradeLog =new FwTradeLog(StatusEnum.TWO);
        fwTradeLog.setProductId(System.currentTimeMillis());
        fwTradeLog.setProductName(productName);
        String transactionId = UUID.randomUUID().toString();
        // 往RocketMQ发送事务消息
        this.rocketMQTemplate.sendMessageInTransaction(
                "fw-pay-order-group", // 事务消息分组，组名
                "pay-success", // 事务消息topic
                MessageBuilder.withPayload(fwTradeLog)
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId)
                        .build(), // 消息
                fwTradeLog // 额外参数，供后续回调使用
        );

    }

    @Override
    @Transactional
    public void payOrder(FwTradeLog fwTradeLog,String transactionId) {
        fwTradeLogService.save(fwTradeLog);
        log.info("[订单状态{}]=>{},当前商品id=>{},商品名称=>{}",fwTradeLog.getOrderId(), StatusEnum.TWO.getDesc(),fwTradeLog.getProductId(),fwTradeLog.getProductName());

        // 记录事务日志
        FwTransactionLog transactionLog = new FwTransactionLog();
        transactionLog.setTransactionId(transactionId);
        String remark = String.format("事务ID为%s的本地事务执行成功", transactionId);
        transactionLog.setRemark(remark);
        fwTransactionLogService.save(transactionLog);
        log.info("事务ID=>{} 本地事务执行成功", transactionId);
//        int i=10/0;
    }
}