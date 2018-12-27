package com.cxl.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Override
    public String service2(String name) {
        return "client22service2Error";
    }
}
