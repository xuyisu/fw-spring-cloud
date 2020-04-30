package com.yisu.drools.query;

import com.yisu.drools.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QueryTest {

    @Autowired
    private KieBase kieBase;

    /**
     * 测试规则的触发
     */
    @Test
    public void testRule(){
        KieSession kieSession = kieBase.newKieSession();

        Student s1 = new Student();
        s1.setAge(50);
        s1.setName("张三");
        Student s2 = new Student();
        s2.setAge(50);
        s2.setName("张三");
        kieSession.insert(s1);
        kieSession.insert(s2);

        //根据名称调用规则文件中定义的查询
        QueryResults results1 = kieSession.getQueryResults("query_1");
        int size = results1.size();
        System.out.println("符合条件的Fact对象个数："+size);
        for (QueryResultsRow row : results1) {
            Student s= (Student) row.get("$s");
            System.out.println(s);
        }

        QueryResults results2 = kieSession.getQueryResults("query_2","李四");
        int size2 = results2.size();
        System.out.println("符合条件的Fact对象个数："+size2);
        for (QueryResultsRow row : results2) {
            Student s= (Student) row.get("$s");
            System.out.println(s);
        }

        kieSession.dispose();
    }
}
