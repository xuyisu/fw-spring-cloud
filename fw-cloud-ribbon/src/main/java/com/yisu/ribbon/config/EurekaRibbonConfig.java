package com.yisu.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.yisu.ribbon.config.custom.MyRule;
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
        //自定义成随机
//        return new RandomRule();
        return new MyRule();
    }

}
