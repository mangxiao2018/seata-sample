package com.mangxiao.orders.Service;

import com.mangxiao.seata.sample.model.Orders;

import java.util.List;

public interface OrderSerevice {
    /**
     * 根据订单号获取该条订单信息
     * @param orders
     * @return
     */
    Orders getOrders(Orders orders);

    /**
     * 获取所有订单数据
     * @return
     */
    List<Orders> getAll();

    /**
     * 新增一条订单信息
     * @param orders
     * @return
     */
    Boolean addOrder(Orders orders);

    /**
     * 根据订单号删除指定的订单
     * @param orderId
     * @return
     */
    Boolean deleteOrder(Long orderId);

    /**
     * 根据订单号更新该条订单信息
     * @param orders
     * @return
     */
    Boolean updateOrder(Orders orders);
}
