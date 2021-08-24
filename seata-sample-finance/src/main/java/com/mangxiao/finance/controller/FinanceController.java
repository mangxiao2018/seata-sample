package com.mangxiao.finance.controller;

import com.mangxiao.common.model.Account;
import com.mangxiao.finance.service.AccountService;
import io.seata.core.context.RootContext;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j(topic = "c.FinanceController")
@RequestMapping("/finance")
@RestController
public class FinanceController {

    @Autowired
    private AccountService accountService;

    /**
     * 财务记账
     * @param orderId
     * @param skuId
     * @param skuName
     * @param skuPrice
     * @param warehouseId
     * @param quantity
     * @return
     */
    @ApiOperation("财务记账")
    @RequestMapping(value = "/accounting")
    @ResponseBody
    public Boolean accounting(@RequestParam("orderId") long orderId,
                              @RequestParam("skuId") long skuId,
                              @RequestParam("skuName") String skuName,
                              @RequestParam("skuPrice") float skuPrice,
                              @RequestParam("warehouseId") long warehouseId,
                              @RequestParam("quantity") int quantity){
        System.out.println("###########finance XID " + RootContext.getXID());
        if(skuId == 0 || skuId == 100100001){
            throw new RuntimeException("故意抛出空指针异常");
        }
        Account account = new Account();
        account.setOrderId(orderId);
        account.setSkuId(skuId);
        account.setSkuName(skuName);
        account.setSkuPrice(skuPrice);
        account.setWarehouseId(warehouseId);
        account.setQuantity(quantity);
        account.setTotalAmount(skuPrice * quantity);
        log.debug("###account###:" + account.toString());
        System.out.println("#################account XID " + RootContext.getXID());
        return accountService.addAccount(account);
    }
}
