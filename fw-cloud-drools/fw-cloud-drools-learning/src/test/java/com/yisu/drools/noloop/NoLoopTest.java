package com.yisu.drools.noloop;

import com.yisu.drools.entity.Student;
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
public class NoLoopTest {

    @Autowired
    private KieBase kieBase;

    /**
     * 测试规则的触发
     */
    @Test
    public void testRule(){
        KieSession kieSession = kieBase.newKieSession();

        Student student = new Student();
        student.setAge(50);
        kieSession.insert(student);

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_noloop_"));
        kieSession.dispose();
    }
}
