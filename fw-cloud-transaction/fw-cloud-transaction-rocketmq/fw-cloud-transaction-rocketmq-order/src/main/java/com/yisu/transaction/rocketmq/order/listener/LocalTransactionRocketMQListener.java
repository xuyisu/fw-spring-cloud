package com.yisu.transaction.rocketmq.order.listener;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yisu.transacation.base.dao.model.FwTradeLog;
import com.yisu.transacation.base.dao.model.FwTransactionLog;
import com.yisu.transacation.base.dao.service.FwTransactionLogService;
import com.yisu.transaction.rocketmq.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 * @description RocketMQ 本地事务执行及事务检查
 * @author xuyisu
 * @date '2020-03-22'
 */
@Slf4j
@Component
@RocketMQTransactionListener(txProducerGroup = "fw-pay-order-group")
public class LocalTransactionRocketMQListener implements RocketMQLocalTransactionListener {

    @Autowired
    private OrderService orderService;
    @Autowired
    private FwTransactionLogService fwTransactionLogService;

    /**
     * 执行本地事务
     * @param message 消息
     * @param o 额外参数
     * @return RocketMQ事务状态
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        MessageHeaders headers = message.getHeaders();
        String transicationId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);

        try {
            FwTradeLog tradeLog = (FwTradeLog) o;
            orderService.payOrder(tradeLog,transicationId); // 对应图中第3步，执行本地事务
            log.info("本地事务=>{} 执行成功，往RocketMQ发送COMMIT",transicationId);
            return RocketMQLocalTransactionState.COMMIT; // 对应图中第4步，COMMIT，半消息经过COMMIT后，消息消费端就可以消费这条消息了
        } catch (Exception e){
            log.info("本地事务=>{} 回滚，往RocketMQ发送ROLLBACK",transicationId ,e);
            return RocketMQLocalTransactionState.ROLLBACK; // 对应途中第4步，ROLLBACK
        }
    }

    /**
     * RocketMQ回查本地事务状态
     * @param message 消息
     * @return RocketMQ事务状态
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        MessageHeaders headers = message.getHeaders();
        String transicationId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);
        log.info("RocketMQ事务状态回查=>{}",transicationId);
        // 从数据库中根据事务Id查询对应的事务日志，对应图中第6步
        FwTransactionLog transactionLog = fwTransactionLogService.getOne(
                new LambdaQueryWrapper<FwTransactionLog>().eq(FwTransactionLog::getTransactionId, transicationId)
        );
        // 对应图中的第7步骤
        return transactionLog != null ? RocketMQLocalTransactionState.COMMIT : RocketMQLocalTransactionState.ROLLBACK;
    }
}
