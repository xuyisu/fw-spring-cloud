package com.yisu.zuul.extend.filter;

import cn.hutool.json.JSONUtil;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.yisu.common.result.FwResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @description  基于redis 集群限流
 * @author xuyisu
 * @date 2020/1/31
 */
@Slf4j
public class LmitFilterCluster extends ZuulFilter {


    //但节点限流
    private static volatile RateLimiter rateLimiter=RateLimiter.create(10.0);
    //集群的限流速度
    private static final long LIMIT_RATE_CLUSTER=100L;
    //初始值
    private static final long LIMIT_INIT_VALUE=0L;
    //设置ContentType类型
    public static final String APPLICATION_JSON_CHARSET_UTF8 = "application/json;charset=utf8";
    //每次限流缓存时间
    private static final int LIMIT_CACHE_TIME=1000;

    @Autowired
    @Qualifier("longRedisTemplate")
    private RedisTemplate<String,Long> redisTemplate;
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
        RequestContext ctx = RequestContext.getCurrentContext();
        long currentSecond = System.currentTimeMillis() / 1000;
        String key="fw-cloud-zuul-extend:"+"limit:"+currentSecond;
        try{
            if(!redisTemplate.hasKey(key)){
                redisTemplate.opsForValue().set(key,LIMIT_INIT_VALUE,LIMIT_CACHE_TIME,TimeUnit.SECONDS);
            }
            Long increment = redisTemplate.opsForValue().increment(key, 1);
            if(increment>=LIMIT_RATE_CLUSTER){
                ctx.setSendZuulResponse(false);
                //失败之后通知后续不应该执行了
                ctx.set("isShould",false);
                ctx.setResponseBody(JSONUtil.toJsonStr(FwResult.failedMsg("当前访问量较大，请稍后重试")));
                ctx.getResponse().setContentType(APPLICATION_JSON_CHARSET_UTF8);
                return null;
            }

        }catch (Exception e){
            log.error("LmitFilterCluster exception:{}",e);
            rateLimiter.acquire();
        }
        return null;
    }
}
