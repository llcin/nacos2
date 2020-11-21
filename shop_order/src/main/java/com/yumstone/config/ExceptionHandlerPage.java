package com.yumstone.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lee.
 * @date 2020/9/9 16:11
 */
@Component
public class ExceptionHandlerPage implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        ResponseData data = null;
        if (e instanceof FlowException) {
            data = new ResponseData(-1, "接口限流了");
        } else if (e instanceof DegradeException) {
            data = new ResponseData(-2, "接口被降级了。。。");
        }
        response.getWriter().write(JSON.toJSONString(data));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class ResponseData {
        private int code;
        private String message;
    }
}
