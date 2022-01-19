package com.neosoft.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neosoft.microservices.model.Role;
import com.neosoft.microservices.repo.RoleDao;

@SpringBootApplication
public class StudentApiApplication implements CommandLineRunner{
	
	@Autowired
	private RoleDao roleDao;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Role adminRole = new Role();
		Role userRole = new Role();
		adminRole.setName("ADMIN");
		userRole.setName("USER");
		
		roleDao.save(adminRole);
		roleDao.save(userRole);
	}

}
