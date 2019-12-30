package com.yisu.hystrix.without;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author xuyisu
 * @description 线程隔离
 * @date 2019/12/30
 */
public class FwHystrixCommondThread extends HystrixCommand<String> {
    private final String name;

    protected FwHystrixCommondThread(String name) {
//        super(HystrixCommandGroupKey.Factory.asKey("myGrop"));
        super(Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("myGrop"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter().withExecutionIsolationStrategy(
                                HystrixCommandProperties.ExecutionIsolationStrategy.THREAD
                        )
                ).andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                                .withCoreSize(10)
                                .withMaxQueueSize(100)
                                .withMaximumSize(100)
                ));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return this.name + ":" + Thread.currentThread().getName();
    }

//    public static void main(String[] args) {
//        String test = new FwHystrixCommond("test").execute();
//        System.out.println(test);
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> test = new FwHystrixCommondThread("test").queue();
        System.out.println(test.get());
    }
}
