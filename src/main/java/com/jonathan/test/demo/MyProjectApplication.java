package com.jonathan.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.ExceptionHandler;

@EntityScan(basePackages = {"com.jonathan.test.demo.entity"})
@EnableJpaRepositories(basePackages = {"com.jonathan.test.demo.repositories"})
@ComponentScan(basePackages = {"com.jonathan.test.demo.service", "com.jonathan.test.demo.controller",
							   "com.jonathan.test.demo.exceptions"})
@SpringBootApplication
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}
}


