package com.yisu.feign.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/9
 */
@FeignClient(value = "fw-register-consul-server")
public interface HelloApi {

    //服务中方法的映射路径
    @GetMapping("/helloWorld")
    String helloWorld();

}
