package com.workops.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
