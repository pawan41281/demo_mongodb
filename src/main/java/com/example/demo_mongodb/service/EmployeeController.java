package com.example.demo_mongodb.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_mongodb.entity.EmployeeEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping("")
	public List<EmployeeEntity> getEmployees() {
		return employeeService.list();
	}
	
	@PostMapping("")
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity entity) {
		return employeeService.save(entity);
	}
	

}
