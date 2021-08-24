package com.mangxiao.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.mangxiao.storage.mapper")
@EnableDiscoveryClient
public class SeataSampleStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataSampleStorageApplication.class, args);
	}

}
