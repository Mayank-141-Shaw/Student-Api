package com.neosoft.microservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.microservices.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	Student findByUsername(String username);

}
