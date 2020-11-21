package com.yumstone.controller;

import com.alibaba.fastjson.JSON;
import com.yumstone.domain.Order;
import com.yumstone.domain.Product;
import com.yumstone.service.OrderService;
import com.yumstone.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

/**
 * @author lee.
 * @date 2020/9/8 13:58
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;


//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid){
//        log.info("接收{}号商品的下单服务",pid);
//        Product product =   restTemplate.getForObject("http://127.0.0.1:8081/product/"+pid, Product.class);
//        log.info("商品信息查询成功={}", JSON.toJSONString(product));
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试");
//        order.setPid(pid);
//        order.setPanme(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.createOrder(order);
//        log.info("下单成功={}", JSON.toJSONString(order));
//        return order;
//    }

//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid){
//        log.info("接收{}号商品的下单服务",pid);
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        ServiceInstance instance = instances.get(0);
//        Product product =   restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/"+pid, Product.class);
//        log.info("商品信息查询成功={}", JSON.toJSONString(product));
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试");
//        order.setPid(pid);
//        order.setPanme(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.createOrder(order);
//        log.info("下单成功={}", JSON.toJSONString(order));
//        return order;
//    }

//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid){
//        log.info("接收{}号商品的下单服务",pid);
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//       int index =  new Random().nextInt(instances.size());
//        ServiceInstance instance = instances.get(index);
//        Product product =   restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/"+pid, Product.class);
//        log.info("商品信息查询成功={}", JSON.toJSONString(product));
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试");
//        order.setPid(pid);
//        order.setPanme(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.createOrder(order);
//        log.info("下单成功={}", JSON.toJSONString(order));
//        return order;
//    }

//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid){
//        log.info("接收{}号商品的下单服务",pid);
//
//        Product product =   restTemplate.getForObject("http://service-product"+"/product/"+pid, Product.class);
//        log.info("商品信息查询成功={}", JSON.toJSONString(product));
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试");
//        order.setPid(pid);
//        order.setPanme(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//        orderService.createOrder(order);
//        log.info("下单成功={}", JSON.toJSONString(order));
//        return order;
//    }

    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接收{}号商品的下单服务", pid);
        Product product = productService.findByPid(pid);
        if (product.getPid() == -1) {
            Order order = new Order();
            order.setPanme("failed");
            return order;
        }
        log.info("商品信息查询成功={},fegin调用成功", JSON.toJSONString(product));
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试");
        order.setPid(pid);
        order.setPanme(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderService.createOrder(order);
        log.info("下单成功={}", JSON.toJSONString(order));
        return order;
    }
    @PreAuthorize("hasAnyAuthority('p1')")
    @RequestMapping("/p1")
    public String test(HttpServletRequest request){
        return request.getSession().getId();
    }
    @PreAuthorize("hasAnyAuthority('p2')")
    @RequestMapping("/p2")
    public String p2(HttpServletRequest request){
        return request.getSession().getId();
    }
    @PreAuthorize("hasAnyAuthority('p3')")
    @RequestMapping("/p3")
    public String p3(HttpServletRequest request){
        return request.getSession().getId();
    }

    @RequestMapping("session")
    public String getSession(HttpServletRequest request){
        return request.getSession().getId();
    }
}
