package com.mangxiao.orders.Service.impl;

import com.mangxiao.orders.Service.BusinessService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.util.List;

/**
 * {@inheritDoc}
 */
public class BusinessServiceImpl implements BusinessService {
    private Log log = LogFactory.getLog(BusinessServiceImpl.class);

    /**
     * {@inheritDoc}
     * @param orderId:人工给定唯一订单号，为了简单
     * @param skuIds:N个商品号
     * @param quantilys:每个商品对应的购买数量
     */
    @Override
    public void purchase(Long orderId, List<Long> skuIds, List<Integer> quantilys) {

    }
}
