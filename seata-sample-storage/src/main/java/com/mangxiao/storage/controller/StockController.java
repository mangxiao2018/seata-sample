package com.mangxiao.storage.controller;

import com.mangxiao.storage.model.Stock;
import com.mangxiao.storage.service.StockService;
import org.apache.ibatis.annotations.Param;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RequestMapping("/stock")
@RestController
public class StockController {
    private static Log log = LogFactory.getLog(StockController.class);

    @Autowired
    private StockService stockService;

    public Stock deduction(@Param("skuId") long skuId,
                           @Param("warehouseId") long warehouseId,
                           @Param("saledQuantity") int saledQuantity){
        Stock s = stockService.getStock(skuId, warehouseId);
        s.setQuantity(s.getQuantity() - saledQuantity);
        s.setUpdateTime(new Date());
        boolean r = stockService.updateStock(s);
        if(r){
            return s;
        }else{
            return null;
        }

    }

}
