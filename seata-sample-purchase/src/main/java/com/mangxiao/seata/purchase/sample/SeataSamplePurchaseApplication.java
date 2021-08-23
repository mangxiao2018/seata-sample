package com.mangxiao.seata.purchase.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.mangxiao.seata.purchase.sample", exclude = {DataSourceAutoConfiguration.class})
public class SeataSamplePurchaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataSamplePurchaseApplication.class, args);
    }
}
