package com.example.springboot03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient // @EnableDiscoveryClient << 두개는 똑같음
public class ZuulServer01 {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServer01.class, args);
    }

}
