package com.rp.microservice.service2.service;

import com.rp.microservice.service2.api.Service2Api;
import org.apache.dubbo.config.annotation.Service;

@Service
public class Service2ApiImpl implements Service2Api {
    public String dubboService2() {
        return "这是第二个service-->Service2ApiImpl";
    }
}
