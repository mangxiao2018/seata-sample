package com.mangxiao.seata.sample.mapper;

import com.mangxiao.seata.sample.model.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrdersMapper {
    @Results(id="OrdersMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "createUserId", column = "create_user_id"),
            @Result(property = "updateUserId", column = "update_user_id"),
            @Result(property = "yn", column = "yn")
    })
    /**
     * 根据订单号获取该条订单信息
     * @param orders
     * @return
     */
    @Select("SELECT id,order_id,create_time,update_time,create_user_id,update_user_id,yn FROM orders WHERE order_id = #{orderId}")
    Orders getOrders(Orders orders);

    /**
     * 获取所有订单数据
     * @return
     */
    @Select("SELECT id,order_id,create_time,update_time,create_user_id,update_user_id,yn FROM orders")
    @ResultMap("OrdersMap")
    List<Orders> getAll();

    /**
     * 新增一条订单信息
     * @param orders
     * @return
     */
    @Insert("INSERT INTO orders (order_id,create_time,update_time,create_user_id,update_user_id,yn) VALUES(#{orderId},#{createTime},#{updateTime},#{createUserId},#{updateUserId},#{yn})")
    int addOrder(Orders orders);

    /**
     * 根据订单号删除指定的订单
     * @param orderId
     * @return
     */
    @Delete("DELETE FROM orders WHERE order_id=#{orderId}")
    int deleteOrder(@Param("orderId") Long orderId);

    /**
     * 根据订单号更新该条订单信息
     * @param orders
     * @return
     */
    @Update("UPDATE orders SET update_time=#{updateTime},update_user_id=#{updateUserId},yn=#{yn} WHERE order_id=#{orderId}")
    int updateOrder(Orders orders);
}
