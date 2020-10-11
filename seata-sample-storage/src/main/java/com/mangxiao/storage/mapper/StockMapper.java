package com.mangxiao.storage.mapper;

import com.mangxiao.storage.model.Stock;
import org.apache.ibatis.annotations.*;

/**
 * 库存Mapper
 */
@Mapper
public interface StockMapper {

    @Results(id="StockMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "skuId", column = "sku_id"),
            @Result(property = "warehouseId", column = "warehouse_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "createUserId", column = "create_user_id"),
            @Result(property = "updateUserId", column = "update_user_id"),
            @Result(property = "yn", column = "yn")
    })
    @Update("UPDATE stock SET quantity=#{quantity} WHERE sku_id=#{skuId} and warehouse_id=#{warehouseId}")
    int update(Stock stock);

    @Select("SELECT id,sku_id,warehouse_id,create_time,update_time,create_user_id,update_user_id,yn FROM stock WHERE sku_id=#{skuId} and warehouse_id=#{warehouseId}")
    Stock getStock(Long skuId,Long warehouseId);
}
