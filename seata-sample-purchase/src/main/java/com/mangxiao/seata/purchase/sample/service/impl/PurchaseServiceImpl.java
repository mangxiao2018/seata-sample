package com.mangxiao.seata.purchase.sample.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mangxiao.seata.purchase.sample.model.Purchase;
import com.mangxiao.seata.purchase.sample.model.Sku;
import com.mangxiao.seata.purchase.sample.model.Stock;
import com.mangxiao.seata.purchase.sample.service.PurchaseService;
import com.mangxiao.seata.purchase.sample.util.OkHttpUtil;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j(topic = "c.PurchaseServiceImpl")
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private RestTemplate restTemplate;
    /** 商品获取接口地址 */
    private static final String SKU_API_URL = "http://10.105.22.153:8083/sku/getSku";
    /** 创建订单接口地址 */
    private static final String ORDER_API_URL = "http://10.105.22.153:8082/order/addOrder";
    /** 财务记账接口地址 */
    private static final String FINANCE_API_URL = "http://10.105.22.153:8084/finance/accounting";
    /** 扣减库存接口地址 */
    private static final String DEDUCTION_STORAGE_API_URL = "http://10.105.22.153:8083/stock/deduction";
    /** 查库存接口地址 */
    private static final String QUARY_STORAGE_API_URL = "http://10.105.22.153:8083/stock/getStocks";

    @GlobalTransactional
    public boolean purchase(Purchase purchase) {
        // 1.获取商品信息
        Sku sku = getSku(purchase);
        // 2.获取库存信息
        Stock stock = getStocks(purchase.getSkuId());
        // 3.创建订单信息
        String orderNo = createOder(sku, purchase, stock);
        // 4.扣减库存
        deduction(purchase, stock);
        // 5.财务记账
        accounting(sku,purchase,stock,orderNo);
        return Boolean.TRUE;
    }

    /**
     * 获取商品信息
     * @param purchase
     * @return
     */
    private Sku getSku(Purchase purchase){
        OkHttpUtil httpUtil = new OkHttpUtil();
        String url = SKU_API_URL + "?skuId=" + purchase.getSkuId();
        String retJson = httpUtil.sendGetRequest(url);
        Sku sku = JSONObject.parseObject(retJson, Sku.class);
        return sku;
    }

    /**
     * 创建订单数据
     * @param sku
     * @param purchase
     * @param stock
     * @return
     */
    private String createOder(Sku sku,Purchase purchase, Stock stock){
        OkHttpUtil httpUtil = new OkHttpUtil();
        String url = ORDER_API_URL + "?skuId=" + sku.getSkuId() +
                "&quantity=" + purchase.getQuantity() +
                "&skuPrice=" + sku.getSkuPrice() +
                "&warehouseId=" + stock.getWarehouseId();
        String retJson = httpUtil.sendGetRequest(url);
        System.out.println("#######orderNo:" + retJson);
        return retJson;
    }

    /**
     * 财务记账
     * @param sku
     * @param purchase
     * @param stock
     * @param orderNo
     */
    private void accounting(Sku sku,Purchase purchase, Stock stock, String orderNo){
        OkHttpUtil httpUtil = new OkHttpUtil();
        String retJson = httpUtil.sendGetRequest(FINANCE_API_URL + "?skuId=" + sku.getSkuId() +
                "&skuName=" + sku.getSkuName() +
                "&skuPrice=" + sku.getSkuPrice() +
                "&quantity=" + purchase.getQuantity() +
                "&orderId=" + Long.valueOf(orderNo) +
                "&warehouseId=" + stock.getWarehouseId());
    }

    /**
     * 扣减库存
     * @param purchase
     * @param stock
     */
    private void deduction(Purchase purchase, Stock stock){
        OkHttpUtil httpUtil = new OkHttpUtil();
        String retJson = httpUtil.sendGetRequest(DEDUCTION_STORAGE_API_URL + "?skuId=" + purchase.getSkuId() +
                "&warehouseId=" + stock.getWarehouseId() +
                "&saledQuantity=" + purchase.getQuantity());
    }

    /**
     * 根据商品编码查库存信息
     * @param skuId
     * @return
     */
    private Stock getStocks(long skuId){
        OkHttpUtil httpUtil = new OkHttpUtil();
        String retJson = httpUtil.sendGetRequest(QUARY_STORAGE_API_URL + "?skuId=" + skuId );
        Stock stock = JSONObject.parseObject(retJson, Stock.class);
        return stock;
    }
}
