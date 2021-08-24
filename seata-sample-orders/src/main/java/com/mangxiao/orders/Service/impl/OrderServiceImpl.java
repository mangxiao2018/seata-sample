package com.mangxiao.orders.Service.impl;

import com.mangxiao.common.model.Orders;
import com.mangxiao.orders.Service.OrderSerevice;
import com.mangxiao.orders.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class OrderServiceImpl implements OrderSerevice {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Orders getOrders(Orders orders) {
        return ordersMapper.getOrders(orders);
    }

    @Override
    public List<Orders> getAll() {
        return ordersMapper.getAll();
    }

    @Override
    public Boolean addOrder(Orders orders) {
        if(ordersMapper.addOrder(orders) > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean deleteOrder(Long orderId) {
        if(ordersMapper.deleteOrder(orderId) > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean updateOrder(Orders orders) {
        if(ordersMapper.updateOrder(orders) > 0){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
