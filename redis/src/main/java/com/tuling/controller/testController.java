package com.tuling.controller;

import com.tuling.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvwei
 * @date 2021/11/10 4:24 下午
 */
@RestController
public class testController {
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("/add")
    public void setName(){
        redisUtil.set("add1","add");

    }
    @RequestMapping("/get")
    public void getName(){
        System.out.println(redisUtil.get("backup2"));
    }

}
