package com.yisu.hystrix.without;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author xuyisu
 * @description 结果缓存
 * @date 2019/12/30
 */
@Slf4j
public class FwHystrixCommondCache extends HystrixCommand<String> {
    private final String name;
    protected FwHystrixCommondCache(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("myGrop"));
        this.name=name;
    }

    @Override
    protected String run(){
        log.info("get data，{}",this.name);
        return this.name+":"+Thread.currentThread().getName();
    }

    @Override
    protected String getCacheKey() {
        return this.name;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        for (int i = 0; i <5 ; i++) {
            FwHystrixCommondCache test = new FwHystrixCommondCache("test");
            log.info(test.execute());
        }
        context.shutdown();
    }
}
