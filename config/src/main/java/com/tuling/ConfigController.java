package com.tuling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvwei
 * @date 2021/10/28 3:58 下午
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {
    @Value("${user.name}")
    private String name;
    @RequestMapping("/get")
    public String test(){
        return name;
    }
}
