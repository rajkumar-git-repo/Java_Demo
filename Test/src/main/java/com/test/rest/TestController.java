package com.test.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Employee;

@RestController
public class TestController {
	
	@Autowired
	@Qualifier("getEmployees")
	private Employee employee;

	@GetMapping(value="/get", produces = "application/json")
    public Employee getEmployee() {
		System.out.println("========="+employee);
        return new Employee(12, "aaa", "aaa@gmail.com");
    }
}
