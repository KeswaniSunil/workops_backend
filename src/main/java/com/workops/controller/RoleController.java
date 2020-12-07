package com.workops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workops.exception.ErrorDetails;
import com.workops.model.Role;
import com.workops.service.RoleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RoleController {

	@Autowired
	RoleService roleservice;
	
	@PostMapping("/api/role/create")
	public ResponseEntity create(@RequestBody Role role) 
	{
		try {
			return new ResponseEntity<>(roleservice.createRole(role),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	@PostMapping("/api/role/update")
	public ResponseEntity update(@RequestBody Role role)
	{
		try {
			return new ResponseEntity<>(roleservice.updateRole(role),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	
	@PostMapping("/api/role/{id}")
	public ResponseEntity findRoleById(@PathVariable int id)
	{
		try {
			return new ResponseEntity<>(roleservice.getRoleById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@PostMapping("/api/role/delete/{id}")
	public ResponseEntity removeRoleById(@PathVariable int id)
	{
		try {
			roleservice.deleteRoleById(id);
			return new ResponseEntity<>("Role SuccessFully Deleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@GetMapping("/api/role/")
	public ResponseEntity findAllRoles()
	{
		try {
			return new ResponseEntity<>(roleservice.getAllRoles(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
}
