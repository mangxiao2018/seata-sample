package com.mangxiao.storage.service.impl;

import com.mangxiao.common.model.Stock;
import com.mangxiao.storage.mapper.StockMapper;
import com.mangxiao.storage.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    public boolean updateStock(Stock stock){
        if(stockMapper.update(stock) > 0){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    @Override
    public Stock getStock(Stock stock) {
        return stockMapper.getStock(stock);
    }
    @Override
    public Stock getStocks(Stock stock) {
        return stockMapper.getStocks(stock);
    }
    @Override
    public List<Stock> getAll() {
        return stockMapper.getAll();
    }
}
