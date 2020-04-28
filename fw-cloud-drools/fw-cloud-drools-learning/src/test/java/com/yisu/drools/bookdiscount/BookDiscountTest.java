package com.yisu.drools.bookdiscount;

import com.yisu.drools.entity.Order;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookDiscountTest {

    @Autowired
    private KieBase kieBase;

    /**
     * 测试规则的触发
     */
    @Test
    public void testRule(){

        KieSession kieSession = kieBase.newKieSession();
        //Fact对象，事实对象
        Order order = new Order();
        order.setOriginalPrice(500d);

        //将Order对象插入到工作内存中
        kieSession.insert(order);

        System.out.println("因为没有触发规则所有限制优惠后价格拿不到："+order.getRealPrice());
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_book_discount_"));
        kieSession.dispose();
        System.out.println("优惠后价格："+order.getRealPrice());
    }

}
