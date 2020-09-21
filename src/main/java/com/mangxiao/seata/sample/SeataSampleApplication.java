package com.mangxiao.seata.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mangxiao.seata.sample")
@MapperScan(basePackages = "com.mangxiao.seata.sample.mapper")
public class SeataSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataSampleApplication.class, args);
    }

}
