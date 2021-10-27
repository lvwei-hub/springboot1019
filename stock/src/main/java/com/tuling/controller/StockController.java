package com.tuling.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvwei
 * @date 2021/10/18 10:38 下午
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @Value("${server.port}")
    private String port;
    @RequestMapping("/reduct")
    public String reduct(){
        System.out.println("减库存成功");
        return "调用"+port+"成功";
    }

}
