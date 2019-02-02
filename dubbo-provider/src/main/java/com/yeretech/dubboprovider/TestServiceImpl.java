package com.yeretech.dubboprovider;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String hello) {
        return "hello";
    }
}
