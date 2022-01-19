package com.microservices;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
@SpringBootApplication
public class StudentOauthAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentOauthAuthorizationApplication.class, args);
	}
	
	@RequestMapping("/validateUser")
	public Principal user(Principal user) {
		return user;
	}
}
