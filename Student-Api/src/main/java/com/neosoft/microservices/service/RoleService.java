package com.neosoft.microservices.service;

import com.neosoft.microservices.model.Role;

public interface RoleService {
	Role findByName(String name);
}
