package com.yumstone.service.fallback;

import com.yumstone.domain.Product;
import com.yumstone.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author lee.
 * @date 2020/9/9 16:48
 */
//容错率 需要实现feige 需要实现接口，feigin 远程调用失败 则调用 当前类的
@Service
public class ProductServiceFallBack implements ProductService {
    @Override
    public Product findByPid(Integer pid) {
        Product product = new Product();
        product.setPname("eee");
        product.setPid(-1);
        return product;
    }
}
