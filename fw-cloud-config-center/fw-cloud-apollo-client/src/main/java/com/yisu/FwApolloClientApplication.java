package com.yisu;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/12
 */
@SpringBootApplication
@EnableApolloConfig
public class FwApolloClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(FwApolloClientApplication.class, args);
    }
}
