package com.hardik.shah.springootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringootDemoApplication.class, args);
	}

}
