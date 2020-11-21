package com.yumstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author lee.
 * @date 2020/9/24 16:59
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableRedisHttpSession
public class UaaApplication {
    public static void main(String[] args) {
        SpringApplication.run(UaaApplication.class);
    }
}
