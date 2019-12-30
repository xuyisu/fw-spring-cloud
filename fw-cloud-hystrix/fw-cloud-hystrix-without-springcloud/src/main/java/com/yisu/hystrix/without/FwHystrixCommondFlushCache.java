package com.yisu.hystrix.without;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author xuyisu
 * @description 清空缓存
 * @date 2019/12/30
 */
@Slf4j
public class FwHystrixCommondFlushCache extends HystrixCommand<String> {

    public static final HystrixCommandKey TEST_KEY = HystrixCommandKey.Factory.asKey("TestKey");
    private final String name;

    protected FwHystrixCommondFlushCache(String name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("myGroup"))
                .andCommandKey(TEST_KEY));
        this.name = name;
    }

    @Override
    protected String run() {
        log.info("get data，{}", this.name);
        return this.name + ":" + Thread.currentThread().getName();
    }

    /**
     * 清理缓存
     *
     * @param name
     */
    private static void flushCache(String name) {
        HystrixRequestCache.getInstance(TEST_KEY,
                HystrixConcurrencyStrategyDefault.getInstance()).clear(name);
    }

    @Override
    protected String getCacheKey() {
        return this.name;
    }

    //    public static void main(String[] args) {
//        String test = new FwHystrixCommond("test").execute();
//        System.out.println(test);
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        String test = new FwHystrixCommondFlushCache("test").execute();
        log.info(test);
//        FwHystrixCommondFlushCache.flushCache("test");
        Future<String> tesFuture = new FwHystrixCommondFlushCache("test").queue();
        log.info(tesFuture.get());
    }
}
