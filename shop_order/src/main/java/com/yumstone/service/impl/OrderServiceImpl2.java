package com.yumstone.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * @author lee.
 * @date 2020/9/9 14:20
 */
@Service
public class OrderServiceImpl2 {
    //定义资源 value
    @SentinelResource(value = "message",blockHandler = "blockHandler",fallback = "fallback")
    public String message(){
        return "message";
    }
    public String blockHandler(BlockException e){
        return "block";
    }
    public String fallback(Throwable e){
        return "throwable";
    }
}
