package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lvwei
 * @date 2021/10/18 10:28 下午
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/add")
    public String add() {
        String forObject = restTemplate.getForObject("http://localhost:8011/stock/reduct", String.class);

        System.out.println("下单成功");
        return "hello"+forObject;
    }

    ;

}
