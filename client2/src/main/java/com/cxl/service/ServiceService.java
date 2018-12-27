package com.cxl.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service")
public interface ServiceService {
    @RequestMapping(value = "/test/hi")
    String hi(@RequestParam(value = "name") String name);
}
