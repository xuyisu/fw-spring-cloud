package com.yisu.gateways.gateway.controller;

import com.yisu.gateways.gateway.result.FwResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @description fallback
 * @author xuyisu
 * @date 2020/1/9
 */
@RestController
public class FallbackController {

    @RequestMapping("fallback/{name}")
    public Mono<FwResult> systemFallback(@PathVariable String name) {
        String response = String.format("访问%s超时或者服务不可用", name);
        return Mono.just(FwResult.failedMsg(response));
    }

}
