package com.rp.nacos.provider.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
public class RestProviderController {




    @GetMapping("/service")
    public String service(HttpServletRequest request){
        System.out.println("----------rest provider controller-------");
        int serverPort = request.getServerPort();
        String requestURI = request.getRequestURI();
        return "rest provider controller-->" + requestURI +"--->"+ serverPort;
    }

//    @GetMapping("/service")
//    public String service(){
//        System.out.println("----------rest provider controller-------");
//        return "rest provider controller";
//    }
}
