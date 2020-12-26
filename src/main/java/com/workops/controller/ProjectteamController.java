package com.workops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workops.model.Projectteam;
import com.workops.model.ProjectteamPK;
import com.workops.model.Userprofile;
import com.workops.service.ProjectteamService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProjectteamController {

	
	@Autowired
	ProjectteamService pts;
	
	@PostMapping("/api/projectteam")
	public ResponseEntity create(@RequestBody Projectteam projectteam) 
	{
		try {
			ObjectMapper mapper = new ObjectMapper();
		      //Converting the Object to JSONString
		      String jsonString = mapper.writeValueAsString(projectteam);
		      System.out.println(jsonString);
			return new ResponseEntity<>(pts.createProjectteam(projectteam),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/api/projectteam/{pid}/{email}")
	public ResponseEntity findProject(@PathVariable String pid,@PathVariable String email)
	{
		try {
			return new ResponseEntity<>(pts.getProjectteamByEmailAndProjectId(pid,email),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}	
	}
	@GetMapping("/api/projectteam/{id}")
	public ResponseEntity findProject(@PathVariable("id") String id)
	{
		try {
			return new ResponseEntity<>(pts.getProjectteamByProjectId(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@DeleteMapping("/api/projectteam/{id}")
	public ResponseEntity deleteProjectById(@PathVariable("id") String id)
	{
		try {
			pts.deleteProjectteamByProjectId(id);
			return new ResponseEntity<>("Porject Deleted Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@DeleteMapping("/api/projectteam/{pid}/{email}")
	public ResponseEntity deleteProjectByKey(@PathVariable String pid,@PathVariable String email)
	{
		System.out.println("innn "+email+" "+pid);
		try {
			pts.deleteProjectteamByEmailAndProjectId(pid,email);
			return new ResponseEntity<>("Project Deleted Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
}
