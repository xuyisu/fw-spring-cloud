package com.yisu.transaction.rocketmq.pay.listener;

import com.yisu.transacation.base.dao.model.FwTradeLog;
import com.yisu.transaction.rocketmq.pay.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * @description 客户端监听
 * @author xuyisu
 * @date '2020-03-22'
 */
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "fw-pay-order-group", topic = "pay-success")
public class PayRocketMQListener implements RocketMQListener<FwTradeLog> {

    @Autowired
    private PayService payService;


    @Override
    public void onMessage(FwTradeLog fwTradeLog) {
        log.info("监听到用户已经下单成功订单id=>{}，名称=>{}的商品", fwTradeLog.getOrderId(), fwTradeLog.getProductName());
        payService.payOrder(fwTradeLog);
    }

}
