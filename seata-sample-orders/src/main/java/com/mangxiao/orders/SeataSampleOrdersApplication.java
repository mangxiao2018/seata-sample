package com.mangxiao.orders;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.mangxiao.orders.mapper")
@EnableDiscoveryClient
public class SeataSampleOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataSampleOrdersApplication.class, args);
	}

}
