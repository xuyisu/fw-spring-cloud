package com.yisu.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yisu.elasticsearch.Model.Order;
import com.yisu.elasticsearch.service.BulkProcessorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Random;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FwElasticSearchApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BulkProcessorServiceTest {


    @Autowired
    BulkProcessorService bulkProcessorService;

    private Order order;

    /**
     *
     * 插入操作
     *
     * */

    @Test
    public void testInsertById(){
        Random random = new Random();
        for(int i = 0 ; i < 1200; i++){
            Order order = new Order();
            int j = random.nextInt(20) % 20 + 1;
            order.setId(i);
            order.setStoreId(j);
            order.setStoreName("旗舰店"+ j);
            order.setCategoryId(j);
            order.setCategoryCode("shirt_"+j);
            order.setProductCode("product_"+i);
            order.setQuantity(random.nextInt(20) % 20 + 1);
            order.setAmount(200 + (random.nextInt(20) % 20 + 1));
            order.setPayDate(new Date());
            String jsonStr = JSON.toJSONString(order, SerializerFeature.WriteDateUseDateFormat);
            bulkProcessorService.insertById("search_index",
                    "search_index", i+"",jsonStr);
        }
    }

    /**
     *
     * 更新操作 将所有数据的销售件数改成0
     *
     * */

    @Test
    public void testUpdateById(){
        for(int i = 0 ; i < 1200; i++){
            Order order = new Order();
            order.setId(i);
            order.setQuantity(0);
            String jsonStr = JSON.toJSONString(order, SerializerFeature.WriteDateUseDateFormat);
            bulkProcessorService.updateById("search_index",
                    "search_index", i+"",jsonStr);
        }
    }

    /**
     *
     * 删除操作
     *
     * */

    @Test
    public void testDeleteById(){
        for(int i = 0 ; i < 1200; i++){
            bulkProcessorService.deleteById("search_index",
                    "search_index", i+"");
        }
    }
}
