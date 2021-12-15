package com.yisu.elasticsearch.service;

import com.yisu.elasticsearch.entity.Order;
import org.elasticsearch.action.search.SearchResponse;
import org.mockito.internal.matchers.Or;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;


/**
 * @author xuyisu
 * @date 2020/10/26
 */
public interface ElasticService {
    void createIndex();

    void deleteIndex(String index);

    void save(Order docBean);

    void saveAll(List<Order> list);

    List<Order> findAll();

    List<Order>  findOrderByStoreName(String storeName);

    List<Order>  findOrderLikeStoreName(String storeName);


}
