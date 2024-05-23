package com.example.springboot03;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/app1")
class AppController{

    @GetMapping
    String f1(){
        System.out.println("app1");

        return "app1";
    }
}

