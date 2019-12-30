package com.yisu.hystrix.without;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author xuyisu
 * @description 信号量
 * @date 2019/12/30
 */
public class FwHystrixCommondSemaphore extends HystrixCommand<String> {
    private final String name;

    protected FwHystrixCommondSemaphore(String name) {
//        super(HystrixCommandGroupKey.Factory.asKey("myGrop"));
        super(HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("myGrop"))
                .andCommandPropertiesDefaults(
                HystrixCommandProperties.Setter().withExecutionIsolationStrategy(
                        HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE
                )
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
        Future<String> test = new FwHystrixCommondSemaphore("test").queue();
        System.out.println(test.get());
    }
}
