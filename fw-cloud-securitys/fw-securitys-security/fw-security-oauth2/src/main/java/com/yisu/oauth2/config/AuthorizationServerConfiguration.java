package com.yisu.oauth2.config;

import cn.hutool.core.util.ArrayUtil;
import com.yisu.oauth2.properties.OAuth2ClientProperties;
import com.yisu.oauth2.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenStore tokenStore;

    @Autowired(required = false)
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired(required = false)
    private TokenEnhancer jwtTokenEnhancer;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
        //扩展token返回结果
        if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null) {
            TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
            List<TokenEnhancer> enhancerList = new ArrayList();
            enhancerList.add(jwtTokenEnhancer);
            enhancerList.add(jwtAccessTokenConverter);
            tokenEnhancerChain.setTokenEnhancers(enhancerList);
            //jwt
            endpoints.tokenEnhancer(tokenEnhancerChain)
                    .accessTokenConverter(jwtAccessTokenConverter);
        }
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
                        .refreshTokenValiditySeconds(60 * 60 * 24 * 15)
                        .authorizedGrantTypes("refresh_token", "password", "authorization_code")//OAuth2支持的验证模式
                        .redirectUris("http://www.baidu.com")
                        .scopes("all");
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
        security.tokenKeyAccess("permitAll()");
        security.checkTokenAccess("isAuthenticated()");
    }
}
