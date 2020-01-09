package com.yisu.gateways.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author xuyisu
 * @description 网关配置
 * @date 2020/1/9
 */
@Configuration
public class GatewayConfig {

    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("fwcloud"));
    }

//    @Bean
//    public KeyResolver ipKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
//    }

//    @Bean
//    KeyResolver apiKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getPath().value());
//    }


}
