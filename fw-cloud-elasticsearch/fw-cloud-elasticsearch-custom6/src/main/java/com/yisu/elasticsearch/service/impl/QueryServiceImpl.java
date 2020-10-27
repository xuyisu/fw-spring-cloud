package com.yisu.elasticsearch.service.impl;

import com.yisu.elasticsearch.Model.Es;
import com.yisu.elasticsearch.service.QueryService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.sum.Sum;
import org.elasticsearch.search.aggregations.pipeline.PipelineAggregatorBuilders;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


/**
 * @author xuyisu
 * @date 2020/10/26
 */
@Service
public class QueryServiceImpl implements QueryService {

    @Resource
    TransportClient transportClient;//注入es操作对象

    @Override
    public List<Map<String, Object>> queryListFromES(Es es, int storeId, String storeName, String startDate, String endDate) {

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String,Object> map = Collections.emptyMap();

        Script script = new Script(ScriptType.INLINE, "painless","params._value0 > 0",map);  //提前定义好查询销量是否大于1000的脚本，类似SQL里面的having

        long beginTime = System.currentTimeMillis();

        SearchResponse sr = transportClient.prepareSearch(es.getIndex()).setTypes(es.getType()) //要查询的表
                .setQuery(QueryBuilders.boolQuery()
                        .must(QueryBuilders.termQuery("store_id", storeId))  //挨个设置查询条件，没有就不加，如果是字符串类型的，要加keyword后缀
                        .must(QueryBuilders.termQuery("store_name.keyword", storeName))
                        .must(QueryBuilders.rangeQuery("pay_date.keyword").gte(startDate).lte(endDate))
                ).addAggregation(
                        AggregationBuilders.terms("by_product_code").field("product_code.keyword").size(2000) //按货号分组，最多查500个货号.SKU直接改字段名字就可以
                                        .subAggregation(AggregationBuilders.sum("quantity").field("quantity"))  //分组计算销量汇总
                                        .subAggregation(AggregationBuilders.sum("amount").field("amount"))  //分组计算实付款汇总，需要加其他汇总的在这里依次加
                                        .subAggregation(PipelineAggregatorBuilders.bucketSelector("sales_bucket_filter",script,"quantity"))//查询是否大于指定值
                                .order(BucketOrder.aggregation("amount", false))) //分组排序

                .execute().actionGet();


        Terms terms = sr.getAggregations().get("by_product_code");   //查询遍历第一个根据货号分组的aggregation

        System.out.println(terms.getBuckets().size());
        for (Terms.Bucket entry : terms.getBuckets()) {
            Map<String,Object> objectMap = new HashMap<>();
            System.out.println("------------------");
            System.out.println("【 " + entry.getKey() + " 】订单数 : " + entry.getDocCount() );

            Sum sum0 = entry.getAggregations().get("quantity"); //取得销量的汇总
            Sum sum1 = entry.getAggregations().get("amount"); //取得销量的汇总

            objectMap.put("product_code", entry.getKey());
            objectMap.put("quantity",sum0.getValue());
            objectMap.put("amount",sum1.getValue());
            list.add(objectMap);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("查询耗时" + ( endTime - beginTime ) + "毫秒");

        return list;
    }

}
