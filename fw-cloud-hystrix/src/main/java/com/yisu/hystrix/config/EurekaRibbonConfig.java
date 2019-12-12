package com.yisu.hystrix.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuyisu
 * @description ribbon配置
 * @date 2019/12/10
 */
@Configuration
public class EurekaRibbonConfig {

    @Bean
    @LoadBalanced // 实现负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule ribbonRule() {

        //默认ZoneAvoidanceRule请求,实现自定义的规则
        //自定义成随机

        return new RandomRule();
    }

}
