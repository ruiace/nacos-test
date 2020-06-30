package com.rp.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestConsumerController {

    @Value("${provider.address}")
    private String providerAddress;

    @GetMapping("/consumer")
    public String consumer(){
        System.out.println("------------rest consumer controller------------");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(providerAddress + "/service", String.class);
        return "rest consumer controller -->" + result;
    }
}
