package com.mangxiao.storage.service;

import com.mangxiao.storage.model.Stock;

import java.util.List;

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
     * @param stock
     * @return
     */
    public Stock getStock(Stock stock);

    /**
     * 获取所有库存数据
     * @return
     */
    List<Stock> getAll();
}
