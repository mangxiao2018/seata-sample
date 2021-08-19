package com.mangxiao.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mangxiao.storage")
@MapperScan(basePackages = "com.mangxiao.storage.mapper")
public class SeataSampleStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataSampleStorageApplication.class, args);
	}

}
