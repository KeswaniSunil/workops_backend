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
import com.workops.model.Issuestatus;
import com.workops.service.IssuestatusService;

@RestController
public class IssuestatusController {


	@Autowired
	IssuestatusService its;
	
	@PostMapping("/api/issuestatuss")
	public ResponseEntity create(@RequestBody Issuestatus issuestatus) throws JsonProcessingException 
	{
		ObjectMapper mapper = new ObjectMapper();
	      //Converting the Object to JSONString
	      String jsonString = mapper.writeValueAsString(issuestatus);
	      System.out.println(jsonString);
		try {
			return new ResponseEntity<>(its.createIssueStatus(issuestatus),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	@PutMapping("/api/issuestatus/")
	public ResponseEntity update(@RequestBody Issuestatus issuestatus)
	{
		try {
			return new ResponseEntity<>(its.updateIssueStatus(issuestatus),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/issuestatus/{id}")
	public ResponseEntity findIssueStatus(@PathVariable("id") String id)
	{
		try {
			return new ResponseEntity<>(its.getIssueStatusById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@DeleteMapping("/api/issuestatus/{id}")
	public ResponseEntity removeIssueStatus(@PathVariable String id)
	{
		try {
			its.deleteIssueStatusById(id);
			return new ResponseEntity<>("Issuestatus SuccessFullyDeleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@GetMapping("/api/issuestatus")
	public ResponseEntity<Object> findAllIssuestatus()
	{
		try {
			return new ResponseEntity<>(its.getAllIssueStatus(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
}
