package com.neosoft.microservices.service;

import java.util.List;

import com.neosoft.microservices.model.User;
import com.neosoft.microservices.model.UserDTO;

public interface UserService {
	User save(UserDTO user);
    List<User> findAll();
    User findOne(String username);
}
