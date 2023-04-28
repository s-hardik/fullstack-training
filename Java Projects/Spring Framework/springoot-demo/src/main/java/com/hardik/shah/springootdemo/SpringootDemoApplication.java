package com.hardik.shah.springootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringootDemoApplication.class, args);
	}

}
