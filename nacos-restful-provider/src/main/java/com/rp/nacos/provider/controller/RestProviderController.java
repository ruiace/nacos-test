package com.rp.nacos.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestProviderController {

    @GetMapping("/service")
    public String service(){
        System.out.println("----------rest provider controller-------");
        return "rest provider controller";
    }
}
