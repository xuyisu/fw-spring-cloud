package com.yisu.gateways.zuul.config;

import com.yisu.gateways.zuul.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/12
 */
@Configuration
public class ZuulConfig {
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}
