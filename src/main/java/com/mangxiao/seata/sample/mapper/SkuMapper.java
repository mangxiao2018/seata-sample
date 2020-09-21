package com.mangxiao.seata.sample.mapper;

import com.mangxiao.seata.sample.model.Sku;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SkuMapper {

    @Select("SELECT id,sku_name,create_time,update_time,create_user_id,update_user_id,yn FROM sku WHERE id = #{sku.id}")
    Sku getSku(Sku sku);

    @Select("SELECT id,sku_name,create_time,update_time,create_user_id,update_user_id,yn FROM sku")
    List<Sku> getAll();

    @Update("UPDATE sku SET sku_name=#{skuName} WHERE id = #{sku.id}")
    int update(Sku sku);

    @Delete("DELETE FROM sku WHERE id = #{id}")
    int delete(Long id);

    @Insert("INSERT INTO sku (sku_name,create_time,update_time,create_user_id,update_user_id,yn) VALUES(#{skuName},#{createTime},#{updateTime},#{createUserId},#{updateUserId},#{yn})")
    int add(Sku sku);
}
