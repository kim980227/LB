package com.example.springboot03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/app1")
class AppController {

    @Autowired
    RestTemplate rt;

    @GetMapping
    String f1() {
        System.out.println("app1");

        String result = rt.getForObject(
                "http://tiger/bpp1",
                String.class);

        return "Ribbon01";
    }
}
