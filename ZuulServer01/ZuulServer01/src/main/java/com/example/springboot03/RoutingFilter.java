package com.example.springboot03;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RoutingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
//        RequestContext context = RequestContext.getCurrentContext();
//        String lastPart = (String) context.get("lastPart");
//
//        RestTemplate restTemplate = new RestTemplate();
//        String destinationUrl = "http://192.168.0.70:8082/app1/" + lastPart;
//
//        // 지정한 URL로 GET 요청을 보내고, 반환 값을 받아옵니다.
//        String response = restTemplate.getForObject(destinationUrl, String.class);
//        context.set("response", response);
//        System.out.println("Response Value from Route Filter: " + response);

        return null;
    }
}
