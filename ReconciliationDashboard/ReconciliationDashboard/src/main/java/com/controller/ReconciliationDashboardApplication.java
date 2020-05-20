package com.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.controller","com.service","com.model"})
public class ReconciliationDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReconciliationDashboardApplication.class, args);
	}

}
