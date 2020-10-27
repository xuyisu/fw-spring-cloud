package com.yisu.elasticsearch.service;


import com.yisu.elasticsearch.Model.Es;

import java.util.List;
import java.util.Map;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
public interface QueryService {

    List<Map<String, Object>> queryListFromES(Es es, int storeId, String storeName, String startDate, String endDate);

}
