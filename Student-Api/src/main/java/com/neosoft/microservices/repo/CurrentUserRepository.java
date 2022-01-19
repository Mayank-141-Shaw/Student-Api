package com.neosoft.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.microservices.model.LoginUser;

public interface CurrentUserRepository extends JpaRepository<LoginUser, Long> {
	
}
