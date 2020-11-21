package com.yumstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.client.RestTemplate;

/**
 * @author lee.
 * @date 2020/9/8 13:55
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableRedisHttpSession
public class OrderApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}
