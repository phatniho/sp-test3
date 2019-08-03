package com.tedu.sp07;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@EnableCircuitBreaker
//@EnableDiscoveryClient
//@SpringBootApplication
@SpringCloudApplication
public class Sp07HystrixApplication {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        SimpleClientHttpRequestFactory sf = new SimpleClientHttpRequestFactory();
        sf.setConnectTimeout(1000);
        sf.setReadTimeout(1000);
        return new RestTemplate(sf);
    }
    public static void main(String[] args) {
        SpringApplication.run(Sp07HystrixApplication.class, args);
    }

}
