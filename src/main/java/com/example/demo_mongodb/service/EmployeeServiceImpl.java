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
	
	public List<EmployeeEntity> list(){
		return employeeRepo.findAll();
	}
	
	public EmployeeEntity find(String id) {
		return employeeRepo.findById(id).get();
	}
	
	public EmployeeEntity save(EmployeeEntity employeeEntity) {
		return employeeRepo.save(employeeEntity);
	}
	
	public EmployeeEntity update(EmployeeEntity employeeEntity) {
		return employeeRepo.save(employeeEntity);
	}
	
	public EmployeeEntity delete(String id) {
		EmployeeEntity employeeEntity = find(id);
		if(employeeEntity!=null)
			employeeRepo.deleteById(id);
		return employeeEntity;
	}
}
