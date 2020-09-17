package com.mangxiao.seata.sample.mapper;

import com.mangxiao.seata.sample.model.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrdersMapper {

    /**
     * 根据订单号获取该条订单信息
     * @param orders
     * @return
     */
    @Select("SELECT id,order_id,create_time,update_time,create_user_id,update_user_id,yn FROM orders WHERE id = #{orders.id}")
    Orders getOrders(Orders orders);

    /**
     * 获取所有订单数据
     * @return
     */
    @Select("SELECT id,order_id,create_time,update_time,create_user_id,update_user_id,yn FROM orders")
    List<Orders> getAll();

    /**
     * 新增一条订单信息
     * @param orders
     * @return
     */
    @Select("INSERT INTO orders (order_id,create_time,update_time,create_user_id,update_user_id,yn) VALUES(#{orderId},#{createTime},#{updateTime},#{createUserId},#{updateUserId},#{yn})")
    int addOrder(Orders orders);

    /**
     * 根据订单号删除指定的订单
     * @param orderId
     * @return
     */
    @Select("DELETE FROM orders WHERE order_id=#{orderId}")
    int deleteOrder(Long orderId);

    /**
     * 根据订单号更新该条订单信息
     * @param orders
     * @return
     */
    @Select("UPDATE orders SET create_time=#{createTime},update_time=#{updateTime},create_user_id=#{createUserId},update_user_id=#{updateUserId},yn=#{yn} WHERE order_id=#{orders.orderId}")
    int updateOrder(Orders orders);
}
