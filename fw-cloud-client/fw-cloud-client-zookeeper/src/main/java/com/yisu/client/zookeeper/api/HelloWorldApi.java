package com.yisu.client.zookeeper.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/9
 */
@Configuration
@EnableFeignClients
public class HelloWorldApi {
    @Autowired
    private TheClient theClient;

    @FeignClient(name = "fw-register-zookeeper")
    interface TheClient {

        @RequestMapping(path = "/helloworld", method = RequestMethod.GET)
        @ResponseBody
        String HelloWorld();
    }

    public String HelloWorld() {
        return theClient.HelloWorld();
    }
}
