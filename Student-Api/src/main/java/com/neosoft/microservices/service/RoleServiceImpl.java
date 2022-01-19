package com.neosoft.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.microservices.model.Role;
import com.neosoft.microservices.repo.RoleDao;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
    private RoleDao roleDao;

    @Override
    public Role findByName(String name) {
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}
