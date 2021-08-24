package com.mangxiao.seata.purchase.sample.feign;

import com.mangxiao.common.model.Sku;
import com.mangxiao.common.model.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-sample-storage")
public interface StorageFeignService {

    @PostMapping("/stock/deduction")
    public Stock deduction(@RequestParam("skuId") long skuId,
                           @RequestParam("warehouseId") long warehouseId,
                           @RequestParam("saledQuantity") int saledQuantity);

    @PostMapping("/sku/getSku")
    public Sku getSku(@RequestParam("skuId") long skuId);

    @PostMapping("/stock/getStocks")
    public Stock getStocks(@RequestParam("skuId") long skuId);
}
