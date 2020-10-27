package com.yisu.elasticsearch.config;

import com.yisu.elasticsearch.util.EmptyUtils;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
@Configuration
public class ElasticSearchConfig {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);


    @Value("${spring.elasticsearch.host}")
    private String host;//elasticsearch的地址

    @Value("${spring.elasticsearch.port}")
    private Integer port;//elasticsearch的端口

    @Value("${elasticsearch.cluster.name}")
    private String clusterName;//集群

    private TransportClient transportClient;

    @Bean
    public TransportClient transportClient(){
        Settings settings = Settings.EMPTY;
        if(!EmptyUtils.isEmpty(clusterName)){
            settings = Settings.builder()
                    .put("cluster.name", clusterName)
                    .build();
        }
        try {
            transportClient = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
        } catch (UnknownHostException e) {
            logger.error("创建elasticsearch客户端失败");
            e.printStackTrace();
        }
        logger.info("创建elasticsearch客户端成功");
        return transportClient;
    }

    @Bean
    public BulkProcessor bulkProcessor() throws UnknownHostException {

        Settings settings = Settings.EMPTY;
        if(!EmptyUtils.isEmpty(clusterName)){
            settings = Settings.builder()
                    .put("cluster.name", clusterName)
                    .build();
        }

        TransportClient transportClient = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));

        return BulkProcessor.builder(transportClient, new BulkProcessor.Listener() {
            @Override
            public void beforeBulk(long l, BulkRequest bulkRequest) {

            }

            @Override
            public void afterBulk(long l, BulkRequest bulkRequest, BulkResponse bulkResponse) {

            }

            @Override
            public void afterBulk(long l, BulkRequest bulkRequest, Throwable throwable) {
                logger.error("{} data bulk failed,reason :{}", bulkRequest.numberOfActions(), throwable);
            }

        }).setBulkActions(1000)//分批，每10000条请求当成一批请求。默认值为1000
                .setBulkSize(new ByteSizeValue(5, ByteSizeUnit.MB))//每次5MB，刷新一次bulk。默认为5m
                .setFlushInterval(TimeValue.timeValueSeconds(5))//每5秒一定执行，不管已经队列积累了多少。默认不设置这个值
                .setConcurrentRequests(1)//设置并发请求数，如果是0，那表示只有一个请求就可以被执行，如果为1，则可以积累并被执行。默认为1.
                .setBackoffPolicy(BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3))//这里有个backoff策略，最初等待100ms,然后按照指数增长并重试3次。每当一个或者多个bulk请求失败,并出现EsRejectedExecutionException异常时.就会尝试重试。这个异常表示用于处理请求的可用计算资源太少。如果要禁用这个backoff策略，需要用backoff.nobackoff()。
                .build();
    }

    @PostConstruct
    void init() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

}
