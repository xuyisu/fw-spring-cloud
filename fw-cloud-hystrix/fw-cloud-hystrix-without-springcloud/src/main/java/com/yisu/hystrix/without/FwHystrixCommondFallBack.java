package com.yisu.hystrix.without;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author xuyisu
 * @description 回退
 * @date 2019/12/30
 */
public class FwHystrixCommondFallBack extends HystrixCommand<String> {

    private final String name;
    protected FwHystrixCommondFallBack(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("myGrop"));
        this.name=name;
    }
    @Override
    protected String run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name+":"+Thread.currentThread().getName();
    }

    /**
     * 默认情况下调用没在1秒内响应，就会触发回退
     * @return
     */
    @Override
    protected String getFallback() {
        return "当前调用失败";
    }

    public static void main(String[] args) {
        String test = new FwHystrixCommondFallBack("test").execute();
        System.out.println(test);
    }
}
