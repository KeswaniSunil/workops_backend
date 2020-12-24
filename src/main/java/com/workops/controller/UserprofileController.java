package com.workops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workops.model.Userprofile;
import com.workops.service.UserprofileService;

@CrossOrigin(origins = "http://localhost:3000")
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
	@GetMapping("/api/userprofiles/{email}")
	public ResponseEntity findUserProfile(@PathVariable String email)
	{
		try {
			return new ResponseEntity<>(ups.getUserprofileByEmail(email),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	
	@DeleteMapping("/api/userprofiles/{id}")
	public ResponseEntity removeProfile(@PathVariable String email)
	{
		try {
			ups.deleteUserprofileByEmail(email);
			return new ResponseEntity<>("Profile SuccessFullyDeleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@PutMapping("/api/userprofiles/switchproject/{email}")
	public ResponseEntity setSelectedProject(@PathVariable String email,@RequestBody Userprofile userprofile)
	{
		try {
			ups.setSelectedProject(email,userprofile);
			return new ResponseEntity<>("Project Selected Successfully",HttpStatus.OK);
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
