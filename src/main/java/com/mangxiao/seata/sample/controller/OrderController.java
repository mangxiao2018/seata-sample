package com.mangxiao.seata.sample.controller;

import com.mangxiao.seata.sample.Service.OrderSerevice;
import com.mangxiao.seata.sample.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderSerevice orderSerevice;

    @RequestMapping(value = "/")
    @ResponseBody
    public List<Orders> getALL(){
        List<Orders> dataList = orderSerevice.getAll();
        return dataList;
    }

}
