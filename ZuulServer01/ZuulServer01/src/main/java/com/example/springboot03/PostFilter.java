package com.example.springboot03;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PostFilter extends ZuulFilter {

    @Autowired
    private TokenGenerator tg;

    @Autowired
    private TokenVerifier tv;

    @Override
    public String filterType() {
        return "post";
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
        RequestContext context = RequestContext.getCurrentContext();
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("post");

        String password = (String) context.get("password");
        System.out.println("password: " + password);

        String token = (String) context.get("token");
        System.out.println("token: " + token);


        if(password != null) {
            System.out.println("contains password");

            String destinationUrl = "http://192.168.0.70:8082/app1/" + password;

            String response = restTemplate.getForObject(destinationUrl, String.class);
            System.out.println("Response Value from Route Filter: " + response);

            if (response.equals("0")) {
                context.setResponseBody("Sign Up Failed !");
            } else {
                String generatedToken = tg.getToken(password);
                System.out.println(generatedToken);
                context.setResponseBody(generatedToken);
            }
            return null;
        }

        if(token != null){
            if(tv.validateToken(token)) {
//                context.setResponseBody("유효한 토큰입니다.");
                String destinationUrl = "http://192.168.0.74:8083/lion";

                String response = restTemplate.getForObject(destinationUrl, String.class);
                context.setResponseBody("유효한 토큰입니다. <br/> 인증에 성공하였습니다. <br/> <br/>" + response);
                System.out.println("Response Value from Route Filter: " + response);
            }
            else context.setResponseBody("유효하지 않은 토큰입니다.");
        }

        return null;
    }
}
