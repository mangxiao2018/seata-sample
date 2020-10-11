package com.mangxiao.storage.service;

import com.mangxiao.storage.model.Stock;

/**
 * 库存Service
 */
public interface StockService {
    /***
     * 更新库存数据
     * @param stock
     * @return
     */
    public boolean updateStock(Stock stock);

    /**
     * 根据商品id，仓库id获取某一库存数据
     * @param skuId
     * @param warehouseId
     * @return
     */
    public Stock getStock(Long skuId,Long warehouseId);
}
