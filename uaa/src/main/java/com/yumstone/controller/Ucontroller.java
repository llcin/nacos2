package com.yumstone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Ucontroller {
    @RequestMapping("index")
    public String loginsuccess(HttpServletRequest request)
    {
        System.out.println(request.getSession().getId());
        return "登录成功";
    }
}
