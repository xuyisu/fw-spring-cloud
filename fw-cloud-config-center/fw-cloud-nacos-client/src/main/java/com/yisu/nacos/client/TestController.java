package com.yisu.nacos.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/26
 */
@RestController
@RequestMapping("/config")
//@RefreshScope
public class TestController {
    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @RequestMapping("/get")
    public boolean get() {
        return useLocalCache;
    }
}
