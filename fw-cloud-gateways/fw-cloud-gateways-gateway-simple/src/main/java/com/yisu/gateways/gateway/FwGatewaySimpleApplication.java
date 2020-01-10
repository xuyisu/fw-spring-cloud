package com.yisu.gateways.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/**
 *
 * @Author xuyisu
 * @Date 2019/12/6
 */
@EnableDiscoveryClient
@SpringBootApplication
public class FwGatewaySimpleApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwGatewaySimpleApplication.class, args);
    }


    /**
     * Java 的流式 API 进行路由的定义
     * @param builder
     * @return
     */
//    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/gateway/**")
                        .filters(f -> f.stripPrefix(1)
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("lb://fw-cloud-ribbon-server")
                        .order(0)
                        .id("strippath_route")
                )
                .build();
    }
}