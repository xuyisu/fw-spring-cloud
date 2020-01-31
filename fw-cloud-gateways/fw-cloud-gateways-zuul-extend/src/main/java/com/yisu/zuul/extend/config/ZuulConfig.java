package com.yisu.zuul.extend.config;

import com.yisu.zuul.extend.filter.LmitFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    @Bean
    public LmitFilter lmitFilter(){
        return new LmitFilter();
    }
}
