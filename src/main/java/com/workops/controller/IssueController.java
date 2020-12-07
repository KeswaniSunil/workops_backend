package com.workops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workops.model.Issue;
import com.workops.service.IssueService;

@RestController
public class IssueController {

	@Autowired
	IssueService iservice;
	
	@PostMapping("/api/issues")
	public ResponseEntity create(@RequestBody Issue issue) throws JsonProcessingException 
	{
		ObjectMapper mapper = new ObjectMapper();
	      //Converting the Object to JSONString
	      String jsonString = mapper.writeValueAsString(issue);
	      System.out.println(jsonString);
		try {
			return new ResponseEntity<>(iservice.createIssue(issue),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	@PutMapping("/api/issues")
	public ResponseEntity update(@RequestBody Issue issue)
	{
		try {
			return new ResponseEntity<>(iservice.updateIssue(issue),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/issues/{id}")
	public ResponseEntity findProject(@PathVariable("id") String id)
	{
		try {
			return new ResponseEntity<>(iservice.getIssueById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@DeleteMapping("/api/issues/{id}")
	public ResponseEntity removeIssue(@PathVariable String id)
	{
		try {
			iservice.deleteIssueById(id);
			return new ResponseEntity<>("Issue SuccessFullyDeleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@GetMapping("/api/issues")
	public ResponseEntity<Object> findAllIssues()
	{
		try {
			return new ResponseEntity<>(iservice.getAllIssues(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
}
