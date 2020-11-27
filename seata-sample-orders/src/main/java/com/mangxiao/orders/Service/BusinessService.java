package com.mangxiao.orders.Service;

import java.util.List;

/**
 * 购买业务接口，模拟购物车下单场景
 * 1.写入订单库表一条订单数据
 * 2.扣减对应商品的库存
 * 3.财务卖出记录销售数据
 */
public interface BusinessService {

    /**
     * 模拟购物车购买N个商品
     * 为了简单实现,ordrId调用该接口时人工给出(只要保证唯一即可)
     * @param orderId:人工给定唯一订单号，为了简单
     * @param skuIds:N个商品号
     * @param quantilys:每个商品对应的购买数量
     */
    public void purchase(Long orderId, List<Long> skuIds, List<Integer> quantilys);
}
