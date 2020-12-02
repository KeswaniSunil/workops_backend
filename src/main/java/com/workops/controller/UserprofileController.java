package com.workops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workops.model.Userprofile;
import com.workops.service.UserprofileService;

@RestController
public class UserprofileController {

	@Autowired
	UserprofileService ups;
	
	@PostMapping("/api/userprofiles")
	public ResponseEntity create(@RequestBody Userprofile userprofile) 
	{
		try {
			return new ResponseEntity<>(ups.createUserprofile(userprofile),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	
	@PutMapping("/api/userprofiles/{id}")
	public ResponseEntity update(@RequestBody Userprofile userprofile)
	{
		try {
			return new ResponseEntity<>(ups.updateUserprofile(userprofile),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	@GetMapping("/api/userprofiles/{id}")
	public ResponseEntity findUserProfile(@RequestBody Userprofile userprofile)
	{
		try {
			return new ResponseEntity<>(ups.getUserprofileByEmail(userprofile),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	
	@PostMapping("/api/userprofiles/{id}")
	public ResponseEntity removeProfile(@RequestBody Userprofile userprofile)
	{
		try {
			ups.deleteUserprofileByEmail(userprofile);
			return new ResponseEntity<>("Profile SuccessFullyDeleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@PutMapping("/api/userprofiles/switchproject")
	public ResponseEntity setSelectedProject(@RequestBody Userprofile userprofile)
	{
		try {
			ups.setSelectedProject(userprofile);
			return new ResponseEntity<>("Project Success Switched",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	

	@GetMapping("/api/userprofiles")
	public ResponseEntity<Object> findAllProfile()
	{
		try {
			return new ResponseEntity<>(ups.getAllUserprofiles(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	
}
