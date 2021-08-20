package com.mangxiao.orders.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j(topic = "c.OrderNoUtil")
public class OrderNoUtil {
    private static long orderNum = 0l;
    private static String date;

    /**
     * 生成订单编号
     * @return
     */
    public static synchronized String getOrderNo() {
        String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        if (date == null || !date.equals(str)) {
            date = str;
            orderNum = 0l;
        }
        orderNum++;
        long orderNo = Long.parseLong((date)) * 10000;
        orderNo += orderNum;
        return orderNo + "";
    }

    public static void main(String[] args){
        for (int i = 0; i < 1000; i++){
            log.debug("订单号:" + OrderNoUtil.getOrderNo());
            System.out.println("订单号:" + OrderNoUtil.getOrderNo());
        }
    }
}
