package com.yisu.elasticsearch.service;


/**
 * @author xuyisu
 * @date 2020/10/26
 */
public interface BulkProcessorService {

    void insertById(String index, String type, String id, String jsonStr);

    void updateById(String index, String type, String id, String jsonStr);

    void deleteById(String index, String type, String id);
}
