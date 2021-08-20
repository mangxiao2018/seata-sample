package com.mangxiao.seata.purchase.sample.service.impl;

import com.mangxiao.seata.purchase.sample.factory.ResultEntity;
import com.mangxiao.seata.purchase.sample.model.Purchase;
import com.mangxiao.seata.purchase.sample.service.PurchaseService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j(topic = "c.PurchaseServiceImpl")
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private RestTemplate restTemplate;
    /** 商品获取接口地址 */
    private static final String SKU_API_URL = "http://localhost:8083/sku/getSku";
    /** 创建订单接口地址 */
    private static final String ORDER_API_URL = "http://localhost:8082/order/addOrder";
    /** 财务记账接口地址 */
    private static final String FINANCE_API_URL = "";
    /** 扣减库存接口地址 */
    private static final String STORAGE_API_URL = "";


    //@GlobalTransactional
    public boolean purchase(Purchase purchase) {
        ResponseEntity<String> response = restTemplate.postForEntity(SKU_API_URL, purchase, String.class);
        String body = response.getBody();
        System.out.println("####body###:" + body);
        /*
        HttpEntity<Purchase> entity = new HttpEntity<>(purchase);
        ResponseEntity<ResultEntity> responseEntity = restTemplate.exchange(SKU_API_URL, HttpMethod.POST,entity, ResultEntity.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        HttpHeaders header = responseEntity.getHeaders();
        ResultEntity resultEntity = responseEntity.getBody();
        log.debug("statusCode:" + statusCode);
        log.debug("header:" + header);
        log.debug("messageEntity:" + resultEntity);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            log.debug("######ok");
        }
        */
        return false;
    }
}
