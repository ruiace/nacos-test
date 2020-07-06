package com.rp.nacos.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
public class SpringRestConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestConsumerBootstrap.class,args);
    }
}
