package com.neosoft.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.microservices.model.CurrentUser;

public interface CurrentUserRepository extends JpaRepository<CurrentUser, Long> {
	
}
