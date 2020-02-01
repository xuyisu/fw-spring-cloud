package com.yisu.zuul.extend.config;

import com.yisu.zuul.extend.filter.LmitFilterCluster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @description  Zuul 配置
 * @author xuyisu
 * @date 2020/1/31
 */
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
