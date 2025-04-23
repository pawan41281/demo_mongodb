package com.example.demo_mongodb.security;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public Optional<User> findByUsernameOrEmail(String username, String email);

	public Boolean existsByUsername(String username);

	public Boolean existsByEmail(String email);
}
