//package com.yisu.register.eureka.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
///**
// * @author xuyisu
// * @description WebSecurityConfig
// * @date 2019/12/31
// */
//@Configuration   开启密码功能需要
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and().sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
//                .and().authorizeRequests().anyRequest().authenticated()
//                .and().csrf().disable();
//    }
//}
//
