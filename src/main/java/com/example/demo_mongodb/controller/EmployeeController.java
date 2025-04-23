package com.example.demo_mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_mongodb.entity.EmployeeEntity;
import com.example.demo_mongodb.service.EmployeeServiceImpl;



@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping("")
	public List<EmployeeEntity> findAll() {
		return employeeService.list();
	}
	
	@GetMapping("/{id}")
	public EmployeeEntity find(@PathVariable String id) {
		return employeeService.find(id);
	}
	
	@PostMapping("")
	public EmployeeEntity save(@RequestBody EmployeeEntity entity) {
		return employeeService.save(entity);
	}
	
	@PatchMapping("")
	public EmployeeEntity update(@RequestBody EmployeeEntity entity) {
		return employeeService.save(entity);
	}
	
	@DeleteMapping("/{id}")
	public EmployeeEntity delete(@PathVariable String id) {
		return employeeService.delete(id);
	}

}
