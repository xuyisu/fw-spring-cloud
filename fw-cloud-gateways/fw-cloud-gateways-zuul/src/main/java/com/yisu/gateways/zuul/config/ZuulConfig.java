package com.yisu.gateways.zuul.config;

import com.yisu.gateways.zuul.filter.TokenFilter;
import com.yisu.gateways.zuul.filter.ZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/12
 */
@Configuration
public class ZuulConfig {
    /**
     * Zuul 过滤器配置，如果不想启动，注释掉即可
     */
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    @Bean
    public ZuulFilter zuulFilter(){
        return new ZuulFilter();
    }
}
