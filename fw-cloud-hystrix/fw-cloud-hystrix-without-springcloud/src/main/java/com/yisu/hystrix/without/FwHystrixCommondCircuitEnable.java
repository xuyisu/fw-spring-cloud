package com.yisu.hystrix.without;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import lombok.extern.slf4j.Slf4j;


import static com.netflix.config.ConfigurationManager.*;

/**
 * @author xuyisu
 * @description 断路器开启
 * @date 2019/12/30
 */
@Slf4j
public class FwHystrixCommondCircuitEnable {

    public static void main(String[] args) {
        //10秒内有10次请求满足第一个条件
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.circuitBreaker.requestVolumeThreshold",10);
        for(int i=0;i<15;i++){
            ErrorCommand c=new ErrorCommand();
            c.execute();
            if(c.isCircuitBreakerOpen()) {
                log.info("当前断路器被打开,在第{}索引",i);
            }
        }
    }
    static class ErrorCommand extends HystrixCommand<String>{
        public ErrorCommand(){
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(500)));
        }
        protected String run() throws InterruptedException{
            Thread.sleep(800);
            return "success";
        }
        protected String getFallback(){
            return "fallback";
        }
    }
}

