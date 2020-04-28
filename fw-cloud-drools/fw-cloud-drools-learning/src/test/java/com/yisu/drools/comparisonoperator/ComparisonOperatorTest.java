package com.yisu.drools.comparisonoperator;

import com.yisu.drools.entity.ComparisonOperator;
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
public class ComparisonOperatorTest {

    @Autowired
    private KieBase kieBase;

    /**
     * 测试规则的触发
     */
    @Test
    public void testRule(){

        KieSession kieSession = kieBase.newKieSession();
        //Fact对象，事实对象
        ComparisonOperator fact = new ComparisonOperator();
        fact.setNames("王五");

        List<String> list = new ArrayList<>();
        list.add("张三2");
        list.add("李四");

        fact.setList(list);

        kieSession.insert(fact);

        kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("rule_comparison_"));
        kieSession.dispose();
    }

}
