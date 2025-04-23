package com.example.demo_mongodb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.example.demo_mongodb.wrapper.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/v1/employees")
@Tag(description = "Employee API", name = "Employee API")
@SecurityRequirement(name = "Bearer Authentication")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping("")
	@Operation(summary = "Get all employees", description = "Fetches all employees from database")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<ApiResponse<List<EmployeeEntity>>> findAll() {
		List<EmployeeEntity> list = employeeService.list();
		Map<String, Integer> map = new HashMap<>();
		map.put("recordCount", list.size());
		ApiResponse<List<EmployeeEntity>> apiResponse = new ApiResponse<>("success", "Record retrieved successfully", list, map);
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Get employee by id",  description = "Fetches a employee using their ID")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<ApiResponse<EmployeeEntity>> find(@PathVariable String id) {
		EmployeeEntity employeeEntity = employeeService.find(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("recordCount", employeeEntity==null?0:1);
		ApiResponse<EmployeeEntity> apiResponse = new ApiResponse<>("success", employeeEntity==null?"Record not found":"Record retrieved successfully", employeeEntity, map);
		return ResponseEntity.ok(apiResponse);
	}
	
	@PostMapping("")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Save employee", description = "Save a new employee in the database")
	public ResponseEntity<ApiResponse<EmployeeEntity>> save(@RequestBody EmployeeEntity entity) {
		EmployeeEntity employeeEntity = employeeService.save(entity);
		Map<String, Integer> map = new HashMap<>();
		map.put("recordCount", employeeEntity==null?0:1);
		ApiResponse<EmployeeEntity> apiResponse = new ApiResponse<>("success", employeeEntity==null?"Record not saved":"Record saved successfully", employeeEntity, map);
		return ResponseEntity.ok(apiResponse);
	}
	
	@PatchMapping("")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Update employee", description = "Update a new employee in the database")
	public ResponseEntity<ApiResponse<EmployeeEntity>> update(@RequestBody EmployeeEntity entity) {
		EmployeeEntity employeeEntity = employeeService.save(entity);
		Map<String, Integer> map = new HashMap<>();
		map.put("recordCount", employeeEntity==null?0:1);
		ApiResponse<EmployeeEntity> apiResponse = new ApiResponse<>("success", employeeEntity==null?"Record not updated":"Record updated successfully", employeeEntity, map);
		return ResponseEntity.ok(apiResponse);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Delete employee", description = "Delete an existing employee from the database")
	public ResponseEntity<ApiResponse<EmployeeEntity>> delete(@PathVariable String id) {
		EmployeeEntity employeeEntity = employeeService.delete(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("recordCount", employeeEntity==null?0:1);
		ApiResponse<EmployeeEntity> apiResponse = new ApiResponse<>("success", employeeEntity==null?"Record not deleted":"Record deleted successfully", employeeEntity, map);
		return ResponseEntity.ok(apiResponse);
	}

}
