package com.yumstone.service;

import com.yumstone.domain.Product;
import com.yumstone.service.fallback.ProductFallBackFactory;
import com.yumstone.service.fallback.ProductServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lee.
 * @date 2020/9/9 9:53
 */
@FeignClient(value = "service-product",
        //fallback = ProductServiceFallBack.class
        fallbackFactory = ProductFallBackFactory.class
) //指定nacos 下的服务
public interface ProductService {
    //@FeignClient value + RequestMapping 的值 == 完成的url
    @RequestMapping("/product/{pid}")//指定请求的uri
    Product findByPid(@PathVariable Integer pid);
}
