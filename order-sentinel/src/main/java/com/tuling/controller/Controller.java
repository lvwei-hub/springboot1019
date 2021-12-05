package com.tuling.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvwei
 * @date 2021/10/29 5:22 下午
 */
@RestController
@RequestMapping("/sentinel")
public class Controller {
    @RequestMapping("/test")
    @SentinelResource(value = "test",blockHandler = "testHandler")
    public String test() {
        return "test";
    }
    public String testHandler(BlockException e) {
        return "流量降级======testHandler";
    }


    @RequestMapping("/flow")
    public String test2() {
        return "flow";
    }

    /**
     * 热点规则
     * @param id
     * @return
     */
    @RequestMapping("/redian/{id}")
    @SentinelResource(value = "getById" ,blockHandler = "redianBlockHandler")
    public String test3(@PathVariable("id")int id) {

        return "flow";
    }
    public String redianBlockHandler(@PathVariable("id")int id,BlockException e) {

        return "热点规则";
    }

}
