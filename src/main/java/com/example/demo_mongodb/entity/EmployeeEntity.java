package com.example.demo_mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

	@Id
	@Indexed(unique = true)
	private String id;
	private String name;
	private String department;
	private String designation;
}
