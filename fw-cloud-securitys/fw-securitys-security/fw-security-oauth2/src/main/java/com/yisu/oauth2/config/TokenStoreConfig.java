package com.yisu.oauth2.config;

import com.yisu.oauth2.jwt.FwJwtTokenEnhancer;
import com.yisu.oauth2.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author xuyisu
 * @description
 * @date 2020/04/11
 */
@Configuration
public class TokenStoreConfig {
    /**
     * redis连接工厂
     */
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    /**
     * 用于存放token
     * @return
     */
    @Bean
    @ConditionalOnProperty(prefix = "fw.security.oauth2", name = "storeType", havingValue = "redis")
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * jwt TOKEN配置信息
     */
    @Configuration
    @ConditionalOnProperty(prefix = "fw.security.oauth2", name = "storeType", havingValue = "jwt", matchIfMissing = true)
    public static class JwtTokenCofnig{

        @Autowired
        private SecurityProperties securityProperties;

        /**
         * 使用jwtTokenStore存储token
         * @return
         */
        @Bean
        public TokenStore jwtTokenStore(){
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        /**
         * 用于生成jwt
         * @return
         */
        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter(){
            JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
            accessTokenConverter.setSigningKey(securityProperties.getOauth().getJwtSigningKey());//生成签名的key
            return accessTokenConverter;
        }

        /**
         * 用于扩展JWT
         * @return
         */
        @Bean
        @ConditionalOnMissingBean(name = "jwtTokenEnhancer")
        public TokenEnhancer jwtTokenEnhancer(){
            return new FwJwtTokenEnhancer();
        }

    }
}
