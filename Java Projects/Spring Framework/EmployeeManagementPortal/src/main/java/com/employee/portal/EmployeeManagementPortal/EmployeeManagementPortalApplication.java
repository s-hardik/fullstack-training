package com.employee.portal.EmployeeManagementPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class EmployeeManagementPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementPortalApplication.class, args);
	}

}
