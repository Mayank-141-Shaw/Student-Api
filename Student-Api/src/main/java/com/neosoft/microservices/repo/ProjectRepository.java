package com.neosoft.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.microservices.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
