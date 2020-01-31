package com.yisu.zuul.extend.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;

public class LmitFilter extends ZuulFilter {
    //可以修改为基于配置中心的方式
    private static volatile RateLimiter rateLimiter=RateLimiter.create(10.0);

    public LmitFilter(){
        super();
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){
        rateLimiter.acquire();
        return null;
    }
}
