package com.rp.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class RestConsumerController {

    @Value("${provider.address}")
    private String providerAddress;

    @Value("${common.test}")
    private String commonTest;

    @Value("${common.age}")
    private String commonAge;

    @Value("${common.name}")
    private String commonName;

    @Value("${common.addr}")
    private String commonAddr;

    @Value("${common.tttt}")
    private String commonTttt;



    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    private String provideServiceId = "nacos-provider";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/consumer")
    public String consumer(){
        System.out.println("------------rest consumer controller------------");
        RestTemplate restTemplate = new RestTemplate();
        //String result = restTemplate.getForObject(providerAddress + "/service", String.class);
        ServiceInstance choose = loadBalancerClient.choose(provideServiceId);

        System.out.println("commonTest==================" + commonTest);
        System.out.println("commonAge==================" + commonAge);
        System.out.println("commonName==================" + commonName);
        System.out.println("commonAddr==================" + commonAddr);
        System.out.println("commonTttt==================" + commonTttt);
        String property = configurableApplicationContext.getEnvironment().getProperty("common.test");
        System.out.println("configurableApplicationContext==================" + property);
        URI uri = choose.getUri();
        String result = restTemplate.getForObject(uri + "/service", String.class);
        return "rest consumer controller -->" + result;
    }

//    @GetMapping("/consumer")
//    public String consumer(){
//        System.out.println("------------rest consumer controller------------");
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(providerAddress + "/service", String.class);
//        return "rest consumer controller -->" + result;
//    }
}
