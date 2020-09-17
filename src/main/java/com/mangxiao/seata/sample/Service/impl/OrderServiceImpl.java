package com.mangxiao.seata.sample.Service.impl;

import com.mangxiao.seata.sample.Service.OrderSerevice;
import com.mangxiao.seata.sample.mapper.OrdersMapper;
import com.mangxiao.seata.sample.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
