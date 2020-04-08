package com.yisu.security.config;

import com.yisu.security.authentication.FwAuthenctiationFailureHandler;
import com.yisu.security.authentication.FwAuthenticationSuccessHandler;
import com.yisu.security.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FwAuthenticationSuccessHandler fwAuthenticationSuccessHandler;

    @Autowired
    private FwAuthenctiationFailureHandler fwAuthenctiationFailureHandler;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(fwAuthenticationSuccessHandler)
                .failureHandler(fwAuthenctiationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
