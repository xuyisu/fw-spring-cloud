package com.yisu.elasticsearch.Model;

import lombok.Data;

/**
 * @author xuyisu
 * @date 2020/10/26
 */
@Data
public class Es {

    private String index;

    private String type;

    public Es(String index, String type) {
        this.index = index;
        this.type = type;
    }
}
