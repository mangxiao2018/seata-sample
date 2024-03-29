package com.mangxiao.storage.service.impl;

import com.mangxiao.common.model.Sku;
import com.mangxiao.storage.mapper.SkuMapper;
import com.mangxiao.storage.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public Sku getSku(Sku sku) {
        return skuMapper.getSku(sku);
    }
}
