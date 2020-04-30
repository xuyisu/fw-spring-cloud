package com.yisu.drools.lhs;

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
public class LhsTest {

    @Autowired
    private KieBase kieBase;

    /**
     * 测试规则的触发
     */
    @Test
    public void testRule(){
        KieSession kieSession = kieBase.newKieSession();

        Student student = new Student();
        student.setAge(15);
        student.setName("lisi");
        kieSession.insert(student);

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_lhs_"));
        kieSession.dispose();
    }
}
