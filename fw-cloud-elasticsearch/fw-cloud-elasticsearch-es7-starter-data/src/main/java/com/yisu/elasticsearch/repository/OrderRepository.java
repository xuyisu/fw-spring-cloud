package com.yisu.elasticsearch.repository;

import com.yisu.elasticsearch.entity.Order;
import com.yisu.elasticsearch.entity.SortingField;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

/**
 * @author xuyisu
 * @description 订单拓展Repository
 * @date 2021/11/9
 */
public interface OrderRepository extends ElasticsearchRepository<Order, Long> {

    /**
     * 根据店铺名称查询订单信息
     * @param storeName
     * @return
     */
    List<Order>  findOrderByStoreName(String storeName);

    /**
     * 根据店铺名称模糊查询
     * @param storeName
     * @return
     */
    List<Order> findOrderByStoreNameLike(String storeName);


}
