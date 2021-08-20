package com.mangxiao.seata.purchase.sample.controller;


import com.mangxiao.seata.purchase.sample.model.Purchase;
import com.mangxiao.seata.purchase.sample.service.PurchaseService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api")
@RestController
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/purchase")
    public Boolean purchase(@Param("skuId") long skuId,
                           @Param("quantity") int quantity){
        Purchase purchase = new Purchase();
        purchase.setSkuId(skuId);
        purchase.setQuantity(quantity);
        Boolean ret = purchaseService.purchase(purchase);
        return ret;
    }

}
