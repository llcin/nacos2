package com.yumtone.filters;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.SetStatusGatewayFilterFactory;
import org.springframework.cloud.gateway.support.HttpStatusHolder;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author lee.
 * @date 2020/9/10 14:55
 */
//自定义过滤器
//@Slf4j
@Component
public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config> {

    //构造函数
    public LogGatewayFilterFactory() {
        super(LogGatewayFilterFactory.Config.class);
    }

    //读取配置文件 赋值到配置中
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("consoleLog","cacheLog");
    }

    public GatewayFilter apply(LogGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                if (config.isCacheLog()){
                  //  log.info("cacheLog.....");
                }
                if (config.isConsoleLog()){
                //    log.info("isConsoleLog.....");
                }
                return chain.filter(exchange);
            }
        };
    }

    @NoArgsConstructor
    @Data
    public static class Config {
        private boolean consoleLog;
        private boolean cacheLog;
    }
}
