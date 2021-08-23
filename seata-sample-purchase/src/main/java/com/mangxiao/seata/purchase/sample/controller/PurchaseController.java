package com.mangxiao.seata.purchase.sample.controller;


import com.mangxiao.seata.purchase.sample.model.Purchase;
import com.mangxiao.seata.purchase.sample.service.PurchaseService;

import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/purchase")
    public Boolean purchase(@RequestParam("skuId") long skuId,
                            @RequestParam("quantity") int quantity){
        System.out.println("###########purchase XID " + RootContext.getXID());
        Purchase purchase = new Purchase();
        purchase.setSkuId(skuId);
        purchase.setQuantity(quantity);
        Boolean ret = purchaseService.purchase(purchase);
        return ret;
    }

}
