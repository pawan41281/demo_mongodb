package com.example.demo_mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_mongodb.entity.EmployeeEntity;
import com.example.demo_mongodb.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public EmployeeEntity save(EmployeeEntity employeeEntity) {
		return employeeRepo.save(employeeEntity);
	}
	
	public List<EmployeeEntity> list(){
		return employeeRepo.findAll();
	}
}
