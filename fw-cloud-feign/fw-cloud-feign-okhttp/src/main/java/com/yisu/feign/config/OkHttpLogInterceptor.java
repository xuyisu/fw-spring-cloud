package com.yisu.feign.config;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author xuyisu
 * @description Url 日志
 * @date 2019/12/28
 */
@Slf4j
public class OkHttpLogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        log.info("OkHttpUrl : " + chain.request().url());
        return chain.proceed(chain.request());
    }
}
