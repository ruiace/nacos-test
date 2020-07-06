package com.rp.nacos.service2.controller;

import com.rp.microservice.service2.api.Service2Api;
import com.rp.nacos.api.Service1Service;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestConsumerController {


    @Reference
    private Service2Api service2Api;

    @Reference
    private Service1Service service1Service;


    @GetMapping("/consumer")
    public String consumer(){
        String result = service2Api.dubboService2();
//        System.out.println("------------rest consumer controller------------");
//        RestTemplate restTemplate = new RestTemplate();
//
//        ServiceInstance choose = loadBalancerClient.choose(provideServiceId);
//
//        URI uri = choose.getUri();
//        String result = restTemplate.getForObject(uri + "/service", String.class);
        return "rest consumer controller -->" + result;
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("------");
        String result = service1Service.test();
        return "rest consumer controller -->" + result;
    }

}
