package com.tuling.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lvwei
 * @date 2021/10/27 4:38 下午
 */
@Configuration
public class FeignConfig {
    public FeignConfig() {
        System.out.println("初始化");
    }
    @Bean
    public Logger.Level feignLoggerLevel(){

        return  Logger.Level.FULL;
    }
}
