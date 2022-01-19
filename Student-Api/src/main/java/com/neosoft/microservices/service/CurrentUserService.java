package com.neosoft.microservices.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.microservices.model.LoginUser;
import com.neosoft.microservices.model.Role;
import com.neosoft.microservices.model.User;
import com.neosoft.microservices.repo.CurrentUserRepository;

@Service
public class CurrentUserService {
	
	@Autowired
	private CurrentUserRepository currentRepo;
	
	@Autowired
	private UserServiceImpl userService;
	
	
	public LoginUser setRoleForCurrentUser(LoginUser loginUser) {
		// find the role of the user
		// username from curent user match with user in userRepo
		// return its roles
		
		loginUser.setRoles(getRolesByUsername(loginUser.getUsername()));
		return loginUser;
	}
	
	public Set<Role> getRolesByUsername(String username){
		User existingUser = userService.findOne(username);
		return existingUser.getRoles();
	}
	
	public void saveNewLoginUser(String username, String password) {
		
		// removing any instance of previous data
        currentRepo.deleteAll();
        
        // we have username and password already
        LoginUser newUser = new LoginUser();
        
        newUser.setUsername(username);
        newUser.setPassword(password);
        
        // get the role of the username and add it to login user
        newUser = setRoleForCurrentUser(newUser);
        
        // adding new username and password to track
        currentRepo.save(newUser);
	}
}
