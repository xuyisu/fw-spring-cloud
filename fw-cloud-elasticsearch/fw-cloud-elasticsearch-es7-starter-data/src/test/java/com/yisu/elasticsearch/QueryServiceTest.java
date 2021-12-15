package com.yisu.elasticsearch;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.yisu.elasticsearch.entity.Order;
import com.yisu.elasticsearch.repository.OrderRepository;
import com.yisu.elasticsearch.service.ElasticService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FwElasticSearchStarterDataApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QueryServiceTest {

    @Autowired
    private ElasticService elasticService;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    @Autowired
    private OrderRepository orderRepository;

    /**
     *
     * 创建index 输入数据
     *
     * */
    @Test
    public void save(){
        Random random = new Random();
        for(int i = 11 ; i < 20; i++){
            Order order = new Order();
            int j = random.nextInt(20) % 20 + 1;
            order.setId(i);
            order.setStoreId(j);
            order.setStoreName("旗舰店"+ j);
            order.setCategoryId(j);
            order.setCategoryCode("目录"+j);
            order.setProductCode("产品"+i);
            order.setQuantity(random.nextInt(20) % 20 + 1);
            order.setAmount(200 + (random.nextInt(20) % 20 + 1));
            order.setPayDate(new Date());
            order.setStoreName(JSON.toJSONString(order));
            elasticService.save(order);
        }

    }


    @Test
    public void findOrderByStoreName(){
        List<Order> storeName = elasticService.findOrderByStoreName("旗舰店1");
        System.out.println(JSONUtil.toJsonStr(storeName));
    }

    @Test
    public void findOrderLikeStoreName(){
        List<Order> storeName = elasticService.findOrderLikeStoreName("旗舰店1");
        System.out.println(JSONUtil.toJsonStr(storeName));
    }


    @Test
    public void searchByKeyWords(){
        List<Order> orders = elasticService.findAll();
        System.out.println(JSONUtil.toJsonStr(orders));
    }



    @Test
    public void search(){
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.should(QueryBuilders.wildcardQuery("storeName.keyword", "*旗舰店1*"));
//        boolQueryBuilder.should(QueryBuilders.wildcardQuery("categoryCode.keyword", "*目录1*"));
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withPageable(PageRequest.of(0, 10))
                .build();

//        Page<Order> orders = orderRepository.search(searchQuery);
//        System.out.println(JSONUtil.toJsonStr(orders));
//        System.out.println("总页数："+orders.getTotalPages());
//        System.out.println("总数量："+orders.getTotalElements());

        AggregatedPage<Order> orders = elasticsearchTemplate.queryForPage(searchQuery, Order.class);
        System.out.println(JSONUtil.toJsonStr(orders));
        System.out.println("总页数："+orders.getTotalPages());
        System.out.println("总数量："+orders.getTotalElements());
    }




}
