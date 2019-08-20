package com.ljj.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ljj
 * @Date: 2019/8/20 14:18
 * @Description:
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello " + name + " you are port is " + port;
    }
}
