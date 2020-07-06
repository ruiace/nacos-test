package com.rp.nacos.server.service;

import com.rp.microservice.service2.api.Service2Api;
import com.rp.nacos.api.Service1Service;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

@Service
public class Service1ServiceImpl implements Service1Service {

    @Reference
    private Service2Api service2Api;

    public String test() {
        String result = service2Api.dubboService2();
        return "这是第一个service1 --->" + result;
    }
}
