package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

import com.test.entity.Employee;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		System.out.println("*************");
	}
	
	@Bean
	public Employee getEmployee() {
		return new Employee(22,"bbb","bbb@gmail.com");
	}

	@Bean
	public Employee getEmployees() {
		return new Employee(33,"ccc","ccc@gmail.com");
	}
}
