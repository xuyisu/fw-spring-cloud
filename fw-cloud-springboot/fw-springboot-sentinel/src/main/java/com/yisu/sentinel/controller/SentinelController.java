package com.yisu.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {


    @SentinelResource(value = "blockSentinel",blockHandler  = "blockHandlerMethod")
    @GetMapping("/blockSentinel")
    public String testBlock(){
        return "blockSentinel 正常返回结果";
    }

    /**
     * 限流执行方法
     * */
    public String blockHandlerMethod(BlockException e){
        e.printStackTrace();
        return "blockSentinel 被限流啦";
    }

    @SentinelResource(value = "fallbackSentinel",fallback = "fallbackMethod")
    @GetMapping("/fallbackSentinel")
    public String testFallback(int count){
        double result=1/count;
        return "fallbackSentinel 正常返回结果:"+result;
    }

    /**
     * 降级执行方法
     * */
    public String fallbackMethod(int count){
        return "fallbackSentinel 错误次数太多，请稍后再试";
    }
}
