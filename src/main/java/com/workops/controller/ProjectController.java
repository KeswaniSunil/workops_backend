package com.workops.controller;

import java.util.List;

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

import com.workops.exception.ErrorDetails;
import com.workops.model.Project;
import com.workops.pojo.ProjectData;
import com.workops.pojo.SwitchProject;
import com.workops.service.ProjectService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProjectController {

	@Autowired
	ProjectService projectservice;
	
	@PostMapping("/api/projects")
	public ResponseEntity create(@RequestBody ProjectData project) 
	{
		try {
			return new ResponseEntity<>(projectservice.createProject(project),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/api/projects")
	public ResponseEntity update(@RequestBody Project project)
	{
		try {
			return new ResponseEntity<>(projectservice.updateProject(project),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/api/projects/{id}")
	public ResponseEntity findProject(@PathVariable String id)
	{
		try {
			return new ResponseEntity<>(projectservice.getProjectById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@DeleteMapping("/api/projects/{id}")
	public ResponseEntity removeProject(@PathVariable String id)
	{
		try {
			projectservice.deleteProjectById(id);
			return new ResponseEntity<>("Project SuccessFullyDeleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/api/projects")
	public ResponseEntity<Object> findAllProject()
	{
		try {
			return new ResponseEntity<>(projectservice.getAllProjects(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/api/projects/userprojects/{emailid}")
	public ResponseEntity<Object> findAllProjectOfUser(@PathVariable("emailid") String emailid)
	{
		try {
			List<String>projsid=projectservice.getProjectIds(emailid);
			System.out.println("pro="+projsid.size());
			if(projsid.size()>0)
			return new ResponseEntity<>(projectservice.getAllUserProjects(projsid),HttpStatus.OK);
			else
				return new ResponseEntity<>("No Projects wih Given email",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
}
