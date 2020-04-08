package com.yisu.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    protected AuthenticationSuccessHandler fwAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler fwAuthenticationFailureHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .successHandler(fwAuthenticationSuccessHandler)
                .failureHandler(fwAuthenticationFailureHandler)
                .and()
                .authorizeRequests().anyRequest().authenticated().and()
                .csrf().disable();

    }

}

