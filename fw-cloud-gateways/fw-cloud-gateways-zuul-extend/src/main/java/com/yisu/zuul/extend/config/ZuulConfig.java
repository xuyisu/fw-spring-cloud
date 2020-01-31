package com.yisu.zuul.extend.config;

import com.yisu.zuul.extend.filter.LmitFilter;
import com.yisu.zuul.extend.filter.LmitFilterCluster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    /**
     * 限流singlon
     * @return
     */
//    @Bean
//    public LmitFilter lmitFilter(){
//        return new LmitFilter();
//    }

    /**
     * 限流集群版
     * @return
     */
    @Bean
    public LmitFilterCluster lmitFilterCluster(){
        return new LmitFilterCluster();
    }
}
