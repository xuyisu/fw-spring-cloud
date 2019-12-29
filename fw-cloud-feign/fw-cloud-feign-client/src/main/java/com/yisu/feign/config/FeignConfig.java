package com.yisu.feign.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.cloud.openfeign.encoding.FeignAcceptGzipEncodingInterceptor;
import org.springframework.cloud.openfeign.encoding.FeignClientEncodingProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuyisu
 * @description
 * @date 2019/12/28
 */
@Configuration
public class FeignConfig {

    /**
     * 输出的日志级别
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    /**
     * 设置Spring Security Basic认证的用户名密码
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","123456");
    }

    /**
     * 自定义认证逻辑
     * @return
     */
//    @Bean
//    public FeignAuthRequestInterceptor basicAuthRequestInterceptor(){
//        return new FeignAuthRequestInterceptor();
//    }

    /**
     * 设置连接超时时间和响应超时时间
     * @return
     */
//    @Bean
//    public Request.Options options(){
//        return new Request.Options(5000,1000);
//    }

//    @Bean
//    public Retryer feignRetryer() {
////        return new Retryer.Default();
//        return  new Retryer.Default(100, 1000, 4);
//    }


}
