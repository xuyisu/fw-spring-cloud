package com.yisu.elasticsearch.service.impl;

import com.yisu.elasticsearch.service.ElasticSearchService;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchServiceImpl.class);

    @Resource
    private TransportClient transportClient;

    @Override
    public void insertById(String index, String type, String id, String jsonStr) {
        transportClient.prepareIndex(index, type,id).setSource(jsonStr, XContentType.JSON).get();
    }

    @Override
    public void updateById(String index, String type, String id, String jsonStr) {
        transportClient.prepareUpdate(index, type,id)
                .setDoc(jsonStr, XContentType.JSON)
                .get();
    }

    @Override
    public void deleteById(String index, String type, String id) {
        transportClient.prepareDelete(index, type, id).get();
    }
}
