package com.tuling;

import com.tuling.openfeign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
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

 /*   @Autowired
    RestTemplate restTemplate;*/
    @Autowired
 StockFeignService stockFeignService;
    @RequestMapping("/add")
    public String add() {
        System.out.println("jinru");
       // String forObject = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
        String reduct = stockFeignService.reduct();
        System.out.println("下单成功");
        return "hello"+reduct;
    }

    @RequestMapping("/test01")
    public String test01() {
        return "test01";
    }
    @RequestMapping("/test02")
    public String test02() {
        return "test02";
    }
    @RequestMapping("/test03")
    public String test03() {
        return "test03";
    }
    @RequestMapping("/test04")
    public String test04() {
        return "test04";
    }
}
