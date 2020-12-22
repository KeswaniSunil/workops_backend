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

import com.workops.model.Issuepriority;
import com.workops.service.IssuepriorityService;

@RestController
public class IssuepriorityController {


	@Autowired
	IssuepriorityService its;
	
	@PostMapping("/api/issueprioritys")
	public ResponseEntity create(@RequestBody Issuepriority issuepriority) 
	{
		try {
			return new ResponseEntity<>(its.createIssuepriority(issuepriority),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/api/issueprioritys/")
	public ResponseEntity update(@RequestBody Issuepriority issuepriority)
	{
		try {
			return new ResponseEntity<>(its.updateIssuepriority(issuepriority),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/api/issueprioritys/{id}")
	public ResponseEntity findIssuepriority(@PathVariable("id") String id)
	{
		try {
			return new ResponseEntity<>(its.getIssuepriorityById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@DeleteMapping("/api/issueprioritys/{id}")
	public ResponseEntity removeIssuePriority(@PathVariable String id)
	{
		try {
			its.deleteIssuepriorityById(id);
			return new ResponseEntity<>("Issuepriority SuccessFullyDeleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/api/issueprioritys")
	public ResponseEntity<Object> findAllIssuepriority()
	{
		try {
			return new ResponseEntity<>(its.getAllIssueprioritys(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
}
