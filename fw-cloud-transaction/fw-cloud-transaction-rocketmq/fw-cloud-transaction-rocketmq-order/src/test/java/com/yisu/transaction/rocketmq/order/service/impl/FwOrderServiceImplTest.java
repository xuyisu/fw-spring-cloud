package com.yisu.transaction.rocketmq.order.service.impl;

import com.yisu.transaction.rocketmq.order.service.FwOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FwOrderServiceImplTest {

    @Autowired
    private FwOrderService fwOrderService;

    @Test
    public void testSelectCount(){
        System.out.println(fwOrderService.count());
    }
}