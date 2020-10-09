package com.mangxiao.storage.mapper;

import com.mangxiao.storage.model.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StockMapper {
    @Update("UPDATE stock SET quantity=#{quantity} WHERE sku_id=#{skuId} and warehouse_id=#{warehouseId}")
    int update(Stock stock);
}
