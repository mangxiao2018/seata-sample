package com.mangxiao.seata.purchase.sample.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-sample-finance")
public interface FinanceFeignService {

    @PostMapping("/finance/accounting")
    public Boolean accounting(@RequestParam("orderId") long orderId,
                              @RequestParam("skuId") long skuId,
                              @RequestParam("skuName") String skuName,
                              @RequestParam("skuPrice") float skuPrice,
                              @RequestParam("warehouseId") long warehouseId,
                              @RequestParam("quantity") int quantity);
}
