package com.ljj.servicefeign.service;

import com.ljj.servicefeign.util.HelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: ljj
 * @Date: 2019/8/20 16:40
 * @Description:
 */
@FeignClient(value = "eureka-client", fallback = HelloServiceHystrix.class)
public interface HelloService {
    @GetMapping("/hello/{name}")
    String hello(@PathVariable("name") String name);
}
