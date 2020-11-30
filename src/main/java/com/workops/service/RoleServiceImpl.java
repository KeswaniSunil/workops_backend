package com.workops.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.RoleDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Role;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roledao;
	@Override
	public List<Role> getAllRoles() {
		return roledao.findAll();
	}

	@Override
	public Optional<Role> getRoleById(Role role) throws Exception {
		try
		{
		Optional<Role> r=roledao.findById(role.getId());
		if(!r.isPresent())
		{
			throw  new ErrorDetails("Not Role Project With Given Id");
		}
		return r;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Role createRole(Role role) throws Exception {
		try
		{
		Optional<Role> r=roledao.findById(role.getId());
		if(!r.isPresent())
		{
			return roledao.save(role);
		}
		throw new ErrorDetails("Role Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Role updateRole(Role role) {
		return roledao.save(role);
	}

	@Override
	public void deleteRoleById(Role role) throws Exception {
		try
		{
		Optional<Role> r=roledao.findById(role.getId());
		if(!r.isPresent())
		{

			throw new ErrorDetails("No Role Exists With this Id");
		}
		roledao.deleteById(role.getId());
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}	
	}


}
