package com.yumtone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lee.
 * @date 2020/9/9 17:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWapApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWapApplication.class);
    }
}
