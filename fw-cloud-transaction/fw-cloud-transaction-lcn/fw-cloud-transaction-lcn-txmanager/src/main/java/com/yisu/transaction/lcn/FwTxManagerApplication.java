package com.yisu.transaction.lcn;


import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableTransactionManagerServer
public class FwTxManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwTxManagerApplication.class, args);
    }
}
