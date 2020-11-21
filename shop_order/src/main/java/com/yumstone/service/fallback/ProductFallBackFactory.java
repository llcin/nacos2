package com.yumstone.service.fallback;

import com.yumstone.domain.Product;
import com.yumstone.service.ProductService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lee.
 * @date 2020/9/9 17:07
 */

/**
 * 容错率
 */
@Slf4j
@Service
public class ProductFallBackFactory implements FallbackFactory<ProductService> {
    @Override
    public ProductService create(Throwable throwable) {
       return  new ProductService() {
           @Override
           public Product findByPid(Integer pid) {
               log.info("throwable,{}",throwable.getMessage());
               log.error("{}",throwable);
               Product product = new Product();
               product.setPid(-1);
               product.setPname("服务调用失败");
               return product;
           }
       };
    }
}
