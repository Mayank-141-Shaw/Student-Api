package com.neosoft.microservices.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.microservices.model.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
    Role findRoleByName(String name);
}