package com.yisu.hystrix.without;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandMetrics;
import com.netflix.hystrix.HystrixCommandProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xuyisu
 * @description 断路器关闭
 * @date 2019/12/30
 */
@Slf4j
public class FwHystrixCommondCircuitClose {
    public static void main(String[] args) throws InterruptedException {
        ConfigurationManager.getConfigInstance().setProperty(
                "hystrix.command.default.circuitBreaker.requestVolumeThreshold", 3);
        boolean isTimeout = true;
        for (int i = 0; i < 10; i++) {
            TestCommand c = new TestCommand(isTimeout);
            c.execute();

            HystrixCommandMetrics.HealthCounts hc = c.getMetrics().getHealthCounts();
            System.out.println("健康信息:" + hc.getTotalRequests());
            if (c.isCircuitBreakerOpen()) {
                isTimeout = false;
                log.info("断路器打开了，第{}索引，等待休眠期结束",i);
                log.info("休眠6秒");
                Thread.sleep(6000);
            }
        }
    }

    static class TestCommand extends HystrixCommand<String> {
        private boolean isTimeout;

        public TestCommand(boolean isTimeout) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(500)));
            this.isTimeout = isTimeout;
        }

        protected String run() throws InterruptedException {
            if (isTimeout) {
                Thread.sleep(800);
            } else {
                Thread.sleep(200);
            }
            return "";
        }

        protected String getFallback() {
            return "fallback";
        }
    }
}

