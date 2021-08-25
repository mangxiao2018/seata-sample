package com.mangxiao.seata.purchase.sample.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mangxiao.common.model.Purchase;
import com.mangxiao.common.model.Sku;
import com.mangxiao.common.model.Stock;
import com.mangxiao.seata.purchase.sample.service.PurchaseService;
import com.mangxiao.seata.purchase.sample.util.OkHttpUtil;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j(topic = "c.PurchaseServiceImpl")
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private RestTemplate restTemplate;
    /** 商品获取接口地址 */
    private static final String SKU_API_URL = "http://10.105.22.106:8083/sku/getSku";
    /** 创建订单接口地址 */
    private static final String ORDER_API_URL = "http://10.105.22.106:8082/order/addOrder";
    /** 财务记账接口地址 */
    private static final String FINANCE_API_URL = "http://10.105.22.106:8084/finance/accounting";
    /** 扣减库存接口地址 */
    private static final String DEDUCTION_STORAGE_API_URL = "http://10.105.22.106:8083/stock/deduction";
    /** 查库存接口地址 */
    private static final String QUARY_STORAGE_API_URL = "http://10.105.22.106:8083/stock/getStocks";


    public boolean purchase(Purchase purchase) {
        // 1.获取商品信息
        Sku sku = getSkuX(purchase);
        // 2.获取库存信息
        Stock stock = getStocksX(purchase.getSkuId());
        // 3.创建订单信息
        String orderNo = createOderX(sku, purchase, stock);
        // 4.扣减库存
        deductionX(purchase, stock);
        // 5.财务记账
        accountingX(sku,purchase,stock,orderNo);
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
        String retJson = httpUtil.get(url);
        Sku sku = JSONObject.parseObject(retJson, Sku.class);
        return sku;
    }
    private Sku getSkuX(Purchase purchase){
        OkHttpUtil httpUtil = new OkHttpUtil();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("skuId",purchase.getSkuId());

        String retJson = httpUtil.post(SKU_API_URL,jsonObject.toString());
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
        String retJson = httpUtil.get(url);
        System.out.println("#######orderNo:" + retJson);
        return retJson;
    }

    private String createOderX(Sku sku,Purchase purchase, Stock stock){
        OkHttpUtil httpUtil = new OkHttpUtil();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("skuId",sku.getSkuId());
        jsonObject.put("quantity",purchase.getQuantity());
        jsonObject.put("skuPrice",sku.getSkuPrice());
        jsonObject.put("warehouseId",stock.getWarehouseId());

        String retJson = httpUtil.post(ORDER_API_URL,jsonObject.toString());

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
        String retJson = httpUtil.get(FINANCE_API_URL + "?skuId=" + sku.getSkuId() +
                "&skuName=" + sku.getSkuName() +
                "&skuPrice=" + sku.getSkuPrice() +
                "&quantity=" + purchase.getQuantity() +
                "&orderId=" + Long.valueOf(orderNo) +
                "&warehouseId=" + stock.getWarehouseId());
    }
    private void accountingX(Sku sku,Purchase purchase, Stock stock, String orderNo){
        OkHttpUtil httpUtil = new OkHttpUtil();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("skuId",sku.getSkuId());
        jsonObject.put("skuName",sku.getSkuName());
        jsonObject.put("quantity",purchase.getQuantity());
        jsonObject.put("skuPrice",sku.getSkuPrice());
        jsonObject.put("orderId",Long.valueOf(orderNo));
        jsonObject.put("warehouseId",stock.getWarehouseId());

        String retJson = httpUtil.post(FINANCE_API_URL,jsonObject.toString());
    }
    /**
     * 扣减库存
     * @param purchase
     * @param stock
     */
    private void deduction(Purchase purchase, Stock stock){
        OkHttpUtil httpUtil = new OkHttpUtil();
        String retJson = httpUtil.get(DEDUCTION_STORAGE_API_URL + "?skuId=" + purchase.getSkuId() +
                "&warehouseId=" + stock.getWarehouseId() +
                "&saledQuantity=" + purchase.getQuantity());
    }
    private void deductionX(Purchase purchase, Stock stock){
        OkHttpUtil httpUtil = new OkHttpUtil();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("skuId",purchase.getSkuId());
        jsonObject.put("saledQuantity",purchase.getQuantity());
        jsonObject.put("warehouseId",stock.getWarehouseId());

        String retJson = httpUtil.post(DEDUCTION_STORAGE_API_URL,jsonObject.toString());
    }
    /**
     * 根据商品编码查库存信息
     * @param skuId
     * @return
     */
    private Stock getStocks(long skuId){
        OkHttpUtil httpUtil = new OkHttpUtil();
        String retJson = httpUtil.get(QUARY_STORAGE_API_URL + "?skuId=" + skuId );
        Stock stock = JSONObject.parseObject(retJson, Stock.class);
        return stock;
    }
    private Stock getStocksX(long skuId){
        OkHttpUtil httpUtil = new OkHttpUtil();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("skuId",skuId);

        String retJson = httpUtil.post(QUARY_STORAGE_API_URL,jsonObject.toString());
        Stock stock = JSONObject.parseObject(retJson, Stock.class);
        return stock;
    }
}
