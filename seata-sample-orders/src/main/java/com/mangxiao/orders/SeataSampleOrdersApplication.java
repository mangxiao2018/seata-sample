package com.mangxiao.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.mangxiao.orders", exclude = DataSourceAutoConfiguration.class)
public class SeataSampleOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataSampleOrdersApplication.class, args);
	}

}
