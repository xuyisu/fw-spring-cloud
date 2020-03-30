package com.yisu.transaction.seata.at.send.controller;

import com.yisu.transacation.base.dao.model.FwTradeLog;
import com.yisu.transaction.seata.at.send.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 发货控制层
 * @author xuyisu
 * @date '2020-03-25'
 */
@RestController
public class SendController {

    @Autowired
    private SendService sendService;

    /**
     * 发货
     * @param tradeLog
     */
    @PostMapping("send")
    public void sendOrder(@RequestBody FwTradeLog tradeLog) {
         sendService.sendOrder(tradeLog);
    }
}
