package com.yumstone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author lee.
 * @date 2020/9/29 16:02
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //安全拦截机制（重要） 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests()
                .antMatchers().permitAll()
                .antMatchers("/r/**").authenticated()//所有/r/**的请求必须认证通过 
        ;
    }

}
