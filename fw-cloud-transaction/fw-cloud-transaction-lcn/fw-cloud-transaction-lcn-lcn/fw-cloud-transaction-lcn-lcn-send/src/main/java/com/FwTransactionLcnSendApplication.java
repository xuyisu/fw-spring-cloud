package com;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类
 * @Author xuyisu
 * @Date 2019/12/6
 */
@EnableDistributedTransaction
@SpringBootApplication
@EnableDiscoveryClient
public class FwTransactionLcnSendApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwTransactionLcnSendApplication.class, args);
    }


}