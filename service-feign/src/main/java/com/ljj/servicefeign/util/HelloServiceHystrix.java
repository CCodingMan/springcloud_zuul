package com.ljj.servicefeign.util;

import com.ljj.servicefeign.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @Auther: ljj
 * @Date: 2019/8/20 17:28
 * @Description:
 */
@Component
public class HelloServiceHystrix implements HelloService {
    @Override
    public String hello(String name) {
        return "hello" + name + "sorry, error";
    }
}
