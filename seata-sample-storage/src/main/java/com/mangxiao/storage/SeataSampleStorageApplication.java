package com.mangxiao.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.mangxiao.storage", exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = "com.mangxiao.storage.mapper")
public class SeataSampleStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataSampleStorageApplication.class, args);
	}

}
