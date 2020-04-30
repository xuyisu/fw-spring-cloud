package com.yisu.drools.global;

import com.yisu.drools.service.UserService;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GlobalTest {

    @Autowired
    private KieBase kieBase;

    /**
     * 测试规则的触发
     */
    @Test
    public void testRule(){
        KieSession kieSession = kieBase.newKieSession();
        //设置全局变量，变量名称必须和规则文件中定义的变量名一致
        kieSession.setGlobal("count",5);

        List<String> list = new ArrayList<String>();
        list.add("李四");
        kieSession.setGlobal("gList",list);

        kieSession.setGlobal("userService",new UserService());
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_global_"));
        kieSession.dispose();
    }
}
