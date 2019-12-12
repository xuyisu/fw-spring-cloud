package com.yisu.hystrix.feign.service;

import com.yisu.hystrix.feign.fallback.EurekaFeignServiceFailure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xuyisu
 * @description feign service
 * @date 2019/12/11
 */
@FeignClient(value = "fw-register-eureka-client", fallback = EurekaFeignServiceFailure.class)
public interface EurekaFeignService {

    //feign中你可以有多个@RequestParam，但只能有不超过一个@RequestBody

    @GetMapping("/hello")
    String hello();
}
