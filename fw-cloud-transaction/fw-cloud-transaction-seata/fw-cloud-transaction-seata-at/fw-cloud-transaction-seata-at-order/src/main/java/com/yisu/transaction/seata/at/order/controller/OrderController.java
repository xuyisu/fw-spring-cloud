package com.yisu.transaction.seata.at.order.controller;

import com.yisu.common.result.FwResult;
import com.yisu.transaction.seata.at.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 订单接口
 * @author xuyisu
 * @date '2020-03-22'
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 下单
     * @return
     */
    @GetMapping("saveOrder")
    public FwResult saveOrder(String productName){
         orderService.saveAndPayOrder(productName);
         return FwResult.ok();
    }


}
