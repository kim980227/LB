package com.example.springboot03;

import org.springframework.web.bind.annotation.*;

@RestController
public class Auth {
    @GetMapping("app1/{password}")
    int f1(@PathVariable String password) {
        int pw = Integer.parseInt(password);
        return (pw % 2 == 1) ? 0 : 1;
    }
}
//
//class Test{
//    public static void main(String[] args) {
//        Auth test = new Auth();
//        System.out.println(test.f1("1000"));
//    }
//}