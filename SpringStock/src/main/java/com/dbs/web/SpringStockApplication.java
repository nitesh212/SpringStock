package com.dbs.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringStockApplication {

	public static void main(String[] args) {
		ApplicationContext context =
		SpringApplication.run(SpringStockApplication.class, args);
	}

}
