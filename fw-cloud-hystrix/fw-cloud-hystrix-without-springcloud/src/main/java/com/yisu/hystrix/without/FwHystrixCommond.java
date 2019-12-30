package com.yisu.hystrix.without;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author xuyisu
 * @description 简单使用
 * @date 2019/12/30
 */
public class FwHystrixCommond extends HystrixCommand<String> {
    private final String name;
    protected FwHystrixCommond(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("myGroup"));
        this.name=name;
    }

    @Override
    protected String run() throws Exception {
        return this.name+":"+Thread.currentThread().getName();
    }

//    public static void main(String[] args) {
//        String test = new FwHystrixCommond("test").execute();
//        System.out.println(test);
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> test = new FwHystrixCommond("test").queue();
        System.out.println(test.get());
    }
}
