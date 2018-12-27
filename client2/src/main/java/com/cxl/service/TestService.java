package com.cxl.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service" ,fallback = TestServiceImpl.class)
public interface TestService {
    @RequestMapping(value = "/test/hi")
    String service2(@RequestParam(value = "name") String name);
}
