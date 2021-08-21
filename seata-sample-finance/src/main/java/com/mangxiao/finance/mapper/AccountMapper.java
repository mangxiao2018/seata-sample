package com.mangxiao.finance.mapper;

import com.mangxiao.finance.model.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {
    @Results(id="AccountMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "skuId", column = "sku_id"),
            @Result(property = "skuName", column = "sku_name"),
            @Result(property = "skuPrice", column = "sku_price"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "totalAmount", column = "total_amount"),
            @Result(property = "warehouseId", column = "warehouse_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "createUserId", column = "create_user_id"),
            @Result(property = "updateUserId", column = "update_user_id"),
            @Result(property = "yn", column = "yn")
    })

    @Insert("INSERT INTO account (order_id,sku_id,sku_name,sku_price,quantity,total_amount,warehouse_id)  VALUES(#{orderId},#{skuId},#{skuName},#{skuPrice},#{quantity},#{totalAmount},#{warehouseId})")
    int addAccount(Account account);
}
