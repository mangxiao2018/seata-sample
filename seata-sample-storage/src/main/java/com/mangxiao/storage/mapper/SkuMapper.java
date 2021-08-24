package com.mangxiao.storage.mapper;

import com.mangxiao.common.model.Sku;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 商品Mapper
 */
@Mapper
@Repository
public interface SkuMapper {

    @Results(id="SkuMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "skuId", column = "sku_id"),
            @Result(property = "skuName", column = "sku_name"),
            @Result(property = "skuPrice", column = "sku_price"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "createUserId", column = "create_user_id"),
            @Result(property = "updateUserId", column = "update_user_id"),
            @Result(property = "yn", column = "yn")
    })
    @Select("SELECT id,sku_id,sku_name,sku_price,create_time,update_time,create_user_id,update_user_id,yn FROM sku WHERE sku_id=#{skuId}")
    Sku getSku(Sku Sku);
}
