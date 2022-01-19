package com.neosoft.microservices.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.microservices.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	
}