package com.yisu;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 * @Author xuyisu
 * @Date 2019/12/6
 */
@EnableDistributedTransaction
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class FwTransactionLcnTccOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwTransactionLcnTccOrderApplication.class, args);
    }


}