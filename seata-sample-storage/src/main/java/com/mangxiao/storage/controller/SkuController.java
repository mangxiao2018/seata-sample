package com.mangxiao.storage.controller;

import com.mangxiao.common.model.Sku;
import com.mangxiao.storage.service.SkuService;
import io.seata.core.context.RootContext;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sku")
@RestController
public class SkuController {

    private static final Log log = LogFactory.getLog(SkuController.class);
    @Autowired
    private SkuService skuService;
    @ApiOperation("根据skuId获取商品信息")
    @RequestMapping(value = "/getSku")
    @ResponseBody
    public Sku getSku(@RequestParam("skuId") long skuId){
        System.out.println("###########sku XID " + RootContext.getXID());
        log.debug("#####skuId##:" + skuId);
        Sku s = new Sku();
        s.setSkuId(skuId);
        log.debug("#####sku##:" + s);
        Sku sku = skuService.getSku(s);
        return sku;
    }
}
