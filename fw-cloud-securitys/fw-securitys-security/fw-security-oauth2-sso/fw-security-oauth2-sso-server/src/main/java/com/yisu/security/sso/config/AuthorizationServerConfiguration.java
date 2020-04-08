package com.yisu.security.sso.config;

import cn.hutool.core.util.ArrayUtil;
import com.yisu.security.sso.properties.OAuth2ClientProperties;
import com.yisu.security.sso.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter())
                .userDetailsService(userDetailsService);
    }

    /**
     * 配置客户端一些信息
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder build = clients.inMemory();
        if (ArrayUtil.isNotEmpty(securityProperties.getOauth().getClients())) {
            for (OAuth2ClientProperties config : securityProperties.getOauth().getClients()) {
                build.withClient(config.getClientId())
                        .secret(passwordEncoder.encode(config.getClientSecret()))
                        .accessTokenValiditySeconds(config.getAccessTokenValiditySeconds())
                        .refreshTokenValiditySeconds(config.getRefreshTokenValiditySecond())
                        .authorizedGrantTypes("refresh_token", "password", "authorization_code")//OAuth2支持的验证模式
                        .redirectUris(config.getRedirectUri())
                        .autoApprove(config.getAutoApprove())//设置自动认证
                        .scopes(config.getScope());
            }
        }
    }


    /**
     * springSecurity 授权表达式，
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("isAuthenticated()");
    }


    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey(securityProperties.getOauth().getJwtSigningKey());
        return accessTokenConverter;
    }
}
