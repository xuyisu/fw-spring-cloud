package com.yisu.hystrix.feign.fallback;

import com.yisu.hystrix.feign.service.EurekaFeignService;
import org.springframework.stereotype.Service;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/12
 */
@Service
public class EurekaFeignServiceFailure implements EurekaFeignService {
    @Override
    public String hello() {
        return "网络异常,稍后再试,请拿好手牌";
    }
}
