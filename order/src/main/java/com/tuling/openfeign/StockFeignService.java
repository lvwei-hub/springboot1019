package com.tuling.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lvwei
 * @date 2021/10/27 3:09 下午
 */

/**
 * name 对应调用服务名
 * path 对应调用服务controller上面的@RequestMapping
 */
@FeignClient(name="stock-service",path = "/stock")
public interface StockFeignService {
    @RequestMapping("/reduct")
    public String reduct();
}
