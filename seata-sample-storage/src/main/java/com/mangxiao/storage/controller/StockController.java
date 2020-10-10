package com.mangxiao.storage.controller;

import com.mangxiao.storage.model.Stock;
import org.apache.ibatis.annotations.Param;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/stock")
@RestController
public class StockController {
    private static Log log = LogFactory.getLog(StockController.class);

    public Stock deduction(@Param("skuId") long skuIid,
                           @Param("warehouseId") long warehouseId,
                           @Param("saledQuantity") int saledQuantity){
        Stock s = new Stock();
        s.setQuantity();
        return s;
    }

}
