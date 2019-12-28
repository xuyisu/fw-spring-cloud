package com.yisu.feign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.NoArgsConstructor;

/**
 * @author xuyisu
 * @description 自定义认证方式
 * @date 2019/12/28
 */
@NoArgsConstructor
public class FeignAuthRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //编写自己的业务逻辑
    }
}
