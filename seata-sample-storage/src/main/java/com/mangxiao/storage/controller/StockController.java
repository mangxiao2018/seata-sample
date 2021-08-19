package com.mangxiao.storage.controller;

import com.mangxiao.storage.model.Stock;
import com.mangxiao.storage.service.StockService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RequestMapping("/stock")
@RestController
public class StockController {
    private static Log log = LogFactory.getLog(StockController.class);

    @Autowired
    private StockService stockService;

    /**
     * 扣减库存
     * @param skuId
     * @param warehouseId
     * @param saledQuantity
     * @return
     */
    @ApiOperation("扣减库存")
    @RequestMapping(value = "/deduction")
    @ResponseBody
    public Stock deduction(@Param("skuId") long skuId,
                           @Param("warehouseId") long warehouseId,
                           @Param("saledQuantity") int saledQuantity){
        Stock stock = new Stock();
        stock.setSkuId(skuId);
        stock.setWarehouseId(warehouseId);
        Stock s = stockService.getStock(stock);
        s.setQuantity(s.getQuantity() - saledQuantity);
        s.setUpdateTime(new Date());
        boolean r = stockService.updateStock(s);
        if(r){
            return s;
        }else{
            return null;
        }
    }

    /**
     * 查某个库存
     * @param skuId
     * @param warehouseId
     * @return
     */
    @ApiOperation("查某个库存")
    @RequestMapping(value = "/getStock")
    @ResponseBody
    public Stock getStock(@Param("skuId") long skuId,
                          @Param("warehouseId") long warehouseId){
        Stock stock = new Stock();
        stock.setSkuId(skuId);
        stock.setWarehouseId(warehouseId);
        Stock s = stockService.getStock(stock);
        return s;
    }

    /**
     * 采购增加库存
     * @param skuId
     * @param warehouseId
     * @param purchasedQuantity
     * @return
     */
    @ApiOperation("增加库存")
    @RequestMapping(value = "/increase")
    @ResponseBody
    public Stock increase(@Param("skuId") long skuId,
                           @Param("warehouseId") long warehouseId,
                           @Param("purchasedQuantity") int purchasedQuantity) {
        Stock stock = new Stock();
        stock.setSkuId(skuId);
        stock.setWarehouseId(warehouseId);
        Stock s = stockService.getStock(stock);
        s.setQuantity(s.getQuantity() + purchasedQuantity);
        s.setUpdateTime(new Date());
        boolean r = stockService.updateStock(s);
        if (r) {
            return s;
        } else {
            return null;
        }
    }

    /**
     * 查所有库存
     * @return
     */
    @ApiOperation("查所有库存")
    @RequestMapping(value = "/getAll")
    @ResponseBody
    public List<Stock> getAll(){
        List<Stock> dataList = stockService.getAll();
        return dataList;
    }

}
