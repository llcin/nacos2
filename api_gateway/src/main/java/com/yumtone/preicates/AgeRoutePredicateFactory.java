package com.yumtone.preicates;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.BeforeRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author lee.
 * @date 2020/9/10 13:20
 */

/**
 * 自动已路由断言工厂类
 */
//@Service
//@Slf4j
//@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {
    //构造函数
    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
       // log.info("AgeRoutePredicateFactory init....");
    }

    //读取配置文件中的参数值
    public List<String> shortcutFieldOrder() {
        //这个位置的顺序必须喝配置文件的 值的顺序对应
        return Arrays.asList("minAge", "maxAge");
    }

    public Predicate<ServerWebExchange> apply(AgeRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                //接收前台的传入的age参数
                //先判断是否为空，
                //不为空再进行路由
                String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("age");
                if (StringUtils.isNotEmpty(ageStr)){
                    int age = Integer.parseInt(ageStr);
                    if (age < config.getMaxAge() && age > config.getMinAge()){
                        return true;
                    }else{
                        return false;
                    }
                }
                return false;
            }
        };
    }

    @Data
    @NoArgsConstructor
    public static class Config {
        private int minAge;  //18
        private int maxAge;  //60
    }
}
