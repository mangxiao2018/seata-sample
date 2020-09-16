package com.mangxiao.seata.sample.mapper;

import com.mangxiao.seata.sample.model.Sku;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SkuMapperTest {
    private static Log log = LogFactory.getLog(SkuMapperTest.class);
    @Autowired
    SkuMapper skuMapper;

    @Test
    public void getSku(){
        Sku sku = new Sku();
        sku.setId(Long.valueOf(1));
        Sku r = skuMapper.getSku(sku);

    }
}
