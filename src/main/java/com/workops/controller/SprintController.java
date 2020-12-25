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

import com.workops.model.Sprint;
import com.workops.pojo.SprintData;
import com.workops.service.SprintService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SprintController {
	@Autowired
	SprintService sprintservice;
	
	@GetMapping("/api/sprint/id/{id}")
	public ResponseEntity<?> findSprint(@PathVariable("id") String id)
	{
		try {
			return new ResponseEntity<>(sprintservice.getSprintById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	
	@GetMapping("/api/sprint/name/{name}")
	public ResponseEntity<?> findSprintBySname(@PathVariable("name") String name)
	{
		try {
			return new ResponseEntity<>(sprintservice.getSprintByName(name),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}	
	}
	
	@DeleteMapping("/api/sprint/{id}")
	public ResponseEntity<?> removeSprint(@PathVariable String id)
	{
		try {
			sprintservice.deleteSprintById(id);
			return new ResponseEntity<>("Sprint SuccessFully Deleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	
	@PutMapping("/api/sprint/")
	public ResponseEntity<?> putupdateSprint(@RequestBody Sprint sprint)
	{
		try {
			return new ResponseEntity<>(sprintservice.updateSprint(sprint),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/api/sprint")
	public ResponseEntity<?> create(@RequestBody SprintData sprint) 
	{
		try {
			return new ResponseEntity<>(sprintservice.createSprint(sprint),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/api/sprints/{projectid}")
	public ResponseEntity<?> findSprintsByProject(@PathVariable("projectid") String projectid)
	{
		try {
			return new ResponseEntity<>(sprintservice.getSprintByProjectid(projectid),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	
}
