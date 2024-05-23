package com.example.springboot03;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        String requestUri = context.getRequest().getRequestURI();
        if (requestUri.matches(".*/app1/.*")) {
            return true;
        }

        if (requestUri.matches(".*/app2/.*")) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        String requestUri = context.getRequest().getRequestURI();


        // 회원가입으로 접속한 경우
        if (requestUri.matches(".*/app1/.*")) {
            String[] parts = requestUri.split("/");
            String lastPart = parts[parts.length - 1]; // 마지막 경로 변수 추출
            System.out.println("prefix");
            context.set("password", lastPart);
            log.debug("PreFitter: password = {}", lastPart);
            System.out.println("app1 password: " + context.get("password"));

            // 로그인으로 접속한 경우
        } else if (requestUri.matches(".*/app2/.*")) {
            String[] parts = requestUri.split("/");
            String lastPart = parts[parts.length - 1]; // 마지막 경로 변수 추출
            System.out.println("prefix");
            context.set("token", lastPart);
            log.debug("PreFitter: token = {}", lastPart);
            System.out.println("app2 token: " + context.get("token"));

        }

        return null;
    }
}
