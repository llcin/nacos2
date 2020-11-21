package com.yumstone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author lee.
 * @date 2020/9/24 17:28
 */
@Configuration
public class TokenConfig {
    private String signing_key = "uaa123";

    /**
     * 令牌存在内存中
     * @return
     */
    @Bean
    public TokenStore tokenStore(){

        return new JwtTokenStore(accessTokenConverter());
    }
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(signing_key);//对称秘钥，资源服务器使用该秘钥来验证   
        return converter;
    }
}
