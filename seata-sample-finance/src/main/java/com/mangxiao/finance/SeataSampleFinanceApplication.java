package com.mangxiao.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.mangxiao.finance", exclude = DataSourceAutoConfiguration.class)
public class SeataSampleFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataSampleFinanceApplication.class, args);
	}

}
