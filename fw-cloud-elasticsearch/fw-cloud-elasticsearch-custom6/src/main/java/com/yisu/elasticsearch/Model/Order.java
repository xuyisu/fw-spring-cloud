package com.yisu.elasticsearch.Model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
@Data
public class Order {

    private long id;

    @JSONField(name="store_id")
    private int storeId;//店铺ID

    @JSONField(name="store_name")
    private String storeName;//店铺名字

    @JSONField(name="category_id")
    private int categoryId;//类目ID

    @JSONField(name="category_code")
    private String categoryCode;//类目名称

    @JSONField(name="product_code")
    private String productCode;//货号

    private int quantity;//销售件数

    private double amount;//销售金额

    @JSONField(name="pay_date")
    private Date payDate;//

    public Order() {
    }

    public Order(long id, int storeId, String storeName, int categoryId, String categoryCode, String productCode, int quantity, double amount, Date payDate) {
        this.id = id;
        this.storeId = storeId;
        this.storeName = storeName;
        this.categoryId = categoryId;
        this.categoryCode = categoryCode;
        this.productCode = productCode;
        this.quantity = quantity;
        this.amount = amount;
        this.payDate = payDate;
    }
}
