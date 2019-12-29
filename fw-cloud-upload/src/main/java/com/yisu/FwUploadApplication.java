package com.yisu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description   上传服务启动类
 * @author xuyisu
 * @date 2019/12/29
 */
@EnableDiscoveryClient
@SpringBootApplication
public class FwUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwUploadApplication.class, args);
    }


}