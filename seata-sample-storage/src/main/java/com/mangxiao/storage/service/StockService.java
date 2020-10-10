package com.mangxiao.storage.service;

import com.mangxiao.storage.model.Stock;

public interface StockService {

    public boolean updateStock(Stock stock);

    public Stock getStock(Long skuId,Long warehouseId);
}
