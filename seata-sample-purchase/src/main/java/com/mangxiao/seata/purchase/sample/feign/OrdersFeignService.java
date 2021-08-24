package com.mangxiao.seata.purchase.sample.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-sample-orders")
public interface OrdersFeignService {

    @PostMapping("/order/addOrder")
    public String addOrder(@RequestParam("skuId") Long skuId,
                           @RequestParam("skuPrice") float skuPrice,
                           @RequestParam("warehouseId") Long warehouseId,
                           @RequestParam("quantity") int quantity);
}
