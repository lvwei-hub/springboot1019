package com.tuling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lvwei
 * @date 2021/10/28 2:58 下午
 */
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);
//        while (true) {
//            String property = applicationContext.getEnvironment().getProperty("user.name");
//            System.out.println(property);
//            Thread.sleep(1000);
//        }

    }


}
