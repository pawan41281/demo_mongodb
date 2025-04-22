package com.example.demo_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_mongodb.entity.EmployeeEntity;

@Repository
public interface EmployeeRepo extends MongoRepository<EmployeeEntity, Long>{
	
	

}
