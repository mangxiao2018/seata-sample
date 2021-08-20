package com.mangxiao.storage.service;

import com.mangxiao.storage.model.Sku;

/**
 * SKU Service
 */
public interface SkuService {
    /**
     * 根据商品id获取某条商品数据
     * @param sku
     * @return
     */
    public Sku getSku(Sku sku);
}
