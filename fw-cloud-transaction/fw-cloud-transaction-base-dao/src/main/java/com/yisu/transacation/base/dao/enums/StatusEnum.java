package com.yisu.transacation.base.dao.enums;

/**
 * @description 启用禁用枚举
 * @author xuyisu
 * @date 2019/2/1
 */
public enum StatusEnum{

    ONE(1, "待支付"),
    TWO(2, "待发货"),
    THREE(3, "待收货"),
    FOUR(4, "订单完成"),
    FIVE(5, "订单关闭");

    private Integer value;
    private String desc;

    StatusEnum(int value, String desc) {
        this.value=value;
        this.desc=desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
