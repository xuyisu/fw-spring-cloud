package com.yisu.elasticsearch.service.impl;

import com.yisu.elasticsearch.entity.Order;
import com.yisu.elasticsearch.repository.OrderRepository;
import com.yisu.elasticsearch.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuyisu
 * @description 实现
 * @date 2021/11/9
 */
@Service("elasticService")
public class ElasticServiceImpl implements ElasticService {
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void createIndex() {
        elasticsearchTemplate.createIndex(Order.class);
    }

    @Override
    public void deleteIndex(String index) {
        elasticsearchTemplate.deleteIndex(index);
    }

    @Override
    public void save(Order docBean) {
        orderRepository.save(docBean);
    }

    @Override
    public void saveAll(List<Order> list) {
        orderRepository.saveAll(list);
    }

    @Override
    public List<Order> findAll() {
        List<Order> list=new ArrayList<>();
        orderRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public List<Order> findOrderByStoreName(String storeName) {
        return orderRepository.findOrderByStoreName(storeName);
    }

    @Override
    public List<Order> findOrderLikeStoreName(String storeName) {
        return orderRepository.findOrderByStoreNameLike(storeName);
    }







}
