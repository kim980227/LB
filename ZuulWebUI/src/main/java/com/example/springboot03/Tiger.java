package com.example.springboot03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Tiger{
}

@FeignClient(name = "noName", url = "http://localhost:8765")
interface TestClient2{
    @RequestMapping("/bpp1")
    String myFunc();
}
//추가코드
@RestController
@RequestMapping("/app1")
class AppController2 {
    @Autowired
    TestClient2 tc;

    @GetMapping("")
    public String f1() {
        System.out.println("app1 : ");
        String str = tc.myFunc();
        return "AppCont1 : " + "<br/>" + str;
    }
}