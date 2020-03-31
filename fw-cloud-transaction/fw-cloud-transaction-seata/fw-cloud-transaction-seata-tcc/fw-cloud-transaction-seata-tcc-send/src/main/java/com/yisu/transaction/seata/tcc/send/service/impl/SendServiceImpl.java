package com.yisu.transaction.seata.tcc.send.service.impl;

import com.yisu.transacation.base.dao.enums.StatusEnum;
import com.yisu.transacation.base.dao.model.FwTradeLog;
import com.yisu.transacation.base.dao.service.FwTradeLogService;
import com.yisu.transaction.seata.tcc.send.service.SendService;
import io.seata.rm.tcc.api.BusinessActionContext;
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

    private static final String LOGIC_PRIMARY_ID = "TRADE_LOG_ID";
    private ConcurrentHashMap<String, Long> hashMap = new ConcurrentHashMap<>();

    @Autowired
    private FwTradeLogService fwTradeLogService;


    @Override
    public void sendOrder(FwTradeLog fwTradeLog) {
        fwTradeLog.setStatus(StatusEnum.THREE.getValue());
        fwTradeLog.setStatusDsc(StatusEnum.THREE.getDesc());
        fwTradeLogService.save(fwTradeLog);
        log.info("[订单状态{}]=>{},当前商品id=>{},商品名称=>{}",fwTradeLog.getOrderId(), StatusEnum.THREE.getDesc(),fwTradeLog.getProductId(),fwTradeLog.getProductName());
        hashMap.put(LOGIC_PRIMARY_ID, fwTradeLog.getId());
    }

    @Override
    public boolean commit(BusinessActionContext businessActionContext) {
        log.info("当前LOGIC_PRIMARY_ID:{},事务执行成功",LOGIC_PRIMARY_ID);
        hashMap.remove(LOGIC_PRIMARY_ID);
        return true;
    }

    @Override
    public boolean cancel(BusinessActionContext businessActionContext) {
        Long tradeLogId = hashMap.get(LOGIC_PRIMARY_ID);
        log.info("事务执行失败，回滚LOGIC_PRIMARY_ID:{}的数据", tradeLogId);
        fwTradeLogService.removeById(tradeLogId);
        hashMap.remove(LOGIC_PRIMARY_ID);
        return true;
    }
}