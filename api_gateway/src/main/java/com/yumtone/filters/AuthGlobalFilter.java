package com.yumtone.filters;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

/**
 * @author lee.
 * @date 2020/9/10 15:14
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    //编写过滤器逻辑
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       String token= exchange.getRequest().getQueryParams().getFirst("token");
       if (!StringUtils.equals("admin",token)){
            log.info("failed");
           exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
           return exchange.getResponse().setComplete();
       }
        return chain.filter(exchange);
    }

    //标识当前过滤器的 优先级 ，越小优先级 越高
    @Override
    public int getOrder() {
        return 0;
    }
}
