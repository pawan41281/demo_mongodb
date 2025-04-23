package com.example.demo_mongodb.security;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "roles")
public class Role {

	@Id
	private String id;
	private String name;
	//private Set<Permission> permissions;
}