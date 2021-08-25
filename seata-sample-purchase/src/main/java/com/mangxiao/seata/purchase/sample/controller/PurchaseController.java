package com.mangxiao.seata.purchase.sample.controller;


import com.mangxiao.common.model.Purchase;
import com.mangxiao.common.model.Sku;
import com.mangxiao.common.model.Stock;
import com.mangxiao.seata.purchase.sample.feign.FinanceFeignService;
import com.mangxiao.seata.purchase.sample.feign.OrdersFeignService;
import com.mangxiao.seata.purchase.sample.feign.StorageFeignService;
import com.mangxiao.seata.purchase.sample.service.PurchaseService;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class PurchaseController {

    @Autowired
    private FinanceFeignService financeFeignService;
    @Autowired
    private StorageFeignService storageFeignService;
    @Autowired
    private OrdersFeignService ordersFeignService;
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping(value = "/purchase")
    @GlobalTransactional
    public Boolean purchase(@RequestParam("skuId") long skuId,
                            @RequestParam("quantity") int quantity,
                            @RequestParam("testflag") int testflag){
        System.out.println("###########purchase XID " + RootContext.getXID());
        Purchase purchase = new Purchase();
        purchase.setSkuId(skuId);
        purchase.setQuantity(quantity);
        if(testflag == 1){
            // 1.获取商品信息
            Sku sku = storageFeignService.getSku(skuId);
            // 2.获取库存信息
            Stock stock = storageFeignService.getStocks(skuId);
            // 3.创建订单信息
            String orderNo = ordersFeignService.addOrder(skuId,sku.getSkuPrice(),stock.getWarehouseId(),stock.getQuantity());
            // 4.扣减库存
            storageFeignService.deduction(skuId,stock.getWarehouseId(),stock.getQuantity());
            // 5.财务记账
            financeFeignService.accounting(Long.valueOf(orderNo),skuId,sku.getSkuName(),sku.getSkuPrice(),stock.getWarehouseId(),stock.getQuantity());
        }else if(testflag == 2){
            purchaseService.purchase(purchase);
        }

        return Boolean.TRUE;
    }

}
