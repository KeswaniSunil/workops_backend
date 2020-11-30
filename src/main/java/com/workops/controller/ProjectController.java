package com.workops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workops.exception.ErrorDetails;
import com.workops.model.Project;
import com.workops.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	ProjectService projectservice;
	
	@PostMapping("/api/project/create")
	public ResponseEntity create(@RequestBody Project project) 
	{
		try {
			return new ResponseEntity<>(projectservice.createProject(project),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	@PostMapping("/api/project/update")
	public ResponseEntity update(@RequestBody Project project)
	{
		try {
			return new ResponseEntity<>(projectservice.updateProject(project),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	
	@PostMapping("/api/project/{id}")
	public ResponseEntity findProjectById(@RequestBody Project project)
	{
		try {
			return new ResponseEntity<>(projectservice.getProjectById(project),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@PostMapping("/api/project/delete/{id}")
	public ResponseEntity removeProjectById(@RequestBody Project project)
	{
		try {
			projectservice.deleteProjectById(project);
			return new ResponseEntity<>("Project SuccessFullyDeleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@GetMapping("/api/project/")
	public ResponseEntity findAllProject()
	{
		try {
			return new ResponseEntity<>(projectservice.getAllProjects(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
}
