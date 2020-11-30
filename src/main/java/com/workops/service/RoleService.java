package com.workops.service;

import java.util.List;

import java.util.Optional;
import com.workops.exception.ErrorDetails;
import com.workops.model.Role;

public interface RoleService {

	List<Role> getAllRoles();
	Optional<Role> getRoleById(Role role)throws Exception;
	Role createRole(Role role) throws Exception;
	Role updateRole(Role role) ;
	void deleteRoleById(Role role) throws Exception;
	
}
