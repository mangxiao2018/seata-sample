package com.mangxiao.orders.controller;

import com.mangxiao.orders.Service.OrderSerevice;
import com.mangxiao.orders.model.Orders;
import com.mangxiao.orders.util.OrderNoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Api("订单管理api")
@RequestMapping(value = "/order")
@RestController
public class OrderController {
    private Log log = LogFactory.getLog(OrderController.class);
    @Autowired
    private OrderSerevice orderSerevice;

    /**
     * 查全部订单
     * @return
     */
    @ApiOperation("查全部订单")
    @RequestMapping(value = "/getAll")
    @ResponseBody
    public List<Orders> getAll(){
        List<Orders> dataList = orderSerevice.getAll();
        return dataList;
    }

    /**
     * 查某个订单
     * @param orderId
     * @return
     */
    @ApiOperation("查某个订单")
    @RequestMapping(value = "/getOrders")
    @ResponseBody
    public Orders getOrders(@Param("orderId") Long orderId){
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        Orders order = orderSerevice.getOrders(orders);
        return order;
    }

    /**
     * 新增订单
     * @param skuId
     */
    @ApiOperation("新增订单")
    @RequestMapping(value = "/addOrder")
    @ResponseBody
    public String addOrder(@Param("skuId") Long skuId,
                            @Param("skuPrice") float skuPrice,
                            @Param("warehouseId") Long warehouseId,
                            @Param("quantity") int quantity){
        Orders orders = new Orders();
        String orderNo = OrderNoUtil.getOrderNo();
        orders.setOrderId(Long.valueOf(orderNo));
        orders.setSkuId(skuId);
        orders.setSkuPrice(skuPrice);
        orders.setWarehouseId(warehouseId);
        orders.setQuantity(quantity);
        orders.setTotalAmount(skuPrice * quantity);
        Boolean r = orderSerevice.addOrder(orders);
        log.info("r:" + r);
        return orderNo;
    }

    /**
     * 订单更新
     * @param orderId
     * @param createUserId
     * @param updateUserId
     * @param yn
     * @return
     */
    @ApiOperation("订单更新")
    @RequestMapping(value = "/updateOrder")
    @ResponseBody
    public boolean updateOrder(@Param("orderId") Long orderId,
                               @Param("createUserId") Long createUserId,
                               @Param("updateUserId") Long updateUserId,
                               @Param("yn") int yn){
        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setUpdateTime(new Date());
        orders.setUpdateUserId(updateUserId);
        orders.setYn(yn);
        Boolean r = orderSerevice.updateOrder(orders);
        log.info("r:" + r);
        return r;
    }

    /**
     * 删除指定订单号的订单信息
     * @param orderId
     * @return
     */
    @ApiOperation("删除指定订单号的订单信息")
    @RequestMapping(value = "/deleteOrder")
    @ResponseBody
    public boolean deleteOrder(@Param("orderId") Long orderId){
        Boolean r = orderSerevice.deleteOrder(orderId);
        log.info("r:" + r);
        return r;
    }
}
