package com.yisu.elasticsearch.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
@Data
@Document(indexName = "order_index_2022",type = "test", shards = 5, replicas = 0)
public class Order {


    private long id;

    /**
     * 店铺ID
     */
    @JSONField(name="store_id")
    private int storeId;

    /**
     * 店铺名字
     */
    @JSONField(name="store_name")
    private String storeName;

    /**
     * 类目ID
     */
    @JSONField(name="category_id")
    private int categoryId;
    /**
     * 类目名称
     */
    @JSONField(name="category_code")
    private String categoryCode;
    /**
     * 货号
     */
    @JSONField(name="product_code")
    private String productCode;
    /**
     * 销售件数
     */
    private int quantity;
    /**
     * 销售金额
     */
    private double amount;
    /**
     * 支付时间
     */
    @JSONField(name="pay_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date payDate;


}
