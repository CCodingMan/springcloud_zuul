package com.ljj.serviceribbon.controller;

import com.ljj.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ljj
 * @Date: 2019/8/20 15:26
 * @Description:
 */
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("serviceRibbon/{name}")
    public String hello(@PathVariable String name){
        return helloService.helloService(name);
    }
}
