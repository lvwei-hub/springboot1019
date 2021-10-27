package com.tuling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author lvwei
 * @date 2021/10/18 10:32 下午
 */
@SpringBootApplication

public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
    @Bean
  @LoadBalanced
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
