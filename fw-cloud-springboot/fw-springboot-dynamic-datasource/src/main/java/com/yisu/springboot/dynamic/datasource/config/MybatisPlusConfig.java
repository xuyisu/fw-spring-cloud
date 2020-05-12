package com.yisu.springboot.dynamic.datasource.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description MybatisPlusConfig
 * @author xuyisu
 * @date '2020-03-22'
 */
@Configuration
@MapperScan(value = "com.yisu.springboot.dynamic.datasource.mapper")
public class MybatisPlusConfig {
    /**
     * 分页插件
     *
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
