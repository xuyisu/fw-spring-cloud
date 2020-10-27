package com.yisu.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yisu.elasticsearch.Model.Order;
import com.yisu.elasticsearch.service.ElasticSearchService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FwElasticSearchApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ElasticSearchServiceTest {


    @Autowired
    ElasticSearchService elasticSearchService;

    private Order order;

    @Before
    public void setUp() throws Exception {
        Order order = new Order(1,12,"旗舰店",1,
                "trousers_01","BX001",1,288, new Date());
        this.order = order;
    }

    /**
     *
     * 插入操作
     *
     * */

    @Test
    public void testInsertById(){
        String jsonStr = JSON.toJSONString(order, SerializerFeature.WriteDateUseDateFormat);
        elasticSearchService.insertById("search_index","search_index",order.getId()+"",jsonStr);
    }

    /**
     *
     * 更新操作
     *
     * */

    @Test
    public void testUpdateById(){
        order.setAmount(299);
        String jsonStr = JSON.toJSONString(order, SerializerFeature.WriteDateUseDateFormat);
        elasticSearchService.updateById("search_index","search_index",order.getId()+"",jsonStr);
    }

    /**
     *
     * 删除操作
     *
     * */

    @Test
    public void testDeleteById(){
        elasticSearchService.deleteById("search_index","search_index", order.getId()+"");
    }

}
