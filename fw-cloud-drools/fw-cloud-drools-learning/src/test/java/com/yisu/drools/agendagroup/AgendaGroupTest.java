package com.yisu.drools.agendagroup;

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
public class AgendaGroupTest {
    @Autowired
    private KieBase kieBase;

    /**
     * 测试规则的触发
     */
    @Test
    public void helloTest(){

        KieSession kieSession = kieBase.newKieSession();
        //指定组获得焦点
        kieSession.getAgenda().getAgendaGroup("agenda_group_1").setFocus();
        //激活规则，由Drools框架自动进行规则匹配，如果规则匹配成功，则执行当前规则
        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_agendagroup_"));
        kieSession.dispose();
    }
}
