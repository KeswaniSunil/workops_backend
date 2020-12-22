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
import com.workops.model.Issuetype;
import com.workops.service.IssuetypeService;

@RestController
public class IssuetypeController {


	@Autowired
	IssuetypeService its;
	
	@PostMapping("/api/issuetypes")
	public ResponseEntity create(@RequestBody Issuetype issuetype) throws JsonProcessingException 
	{
		ObjectMapper mapper = new ObjectMapper();
	      //Converting the Object to JSONString
	      String jsonString = mapper.writeValueAsString(issuetype);
	      System.out.println(jsonString);
		try {
			return new ResponseEntity<>(its.createIssuetype(issuetype),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/api/issuetypes/")
	public ResponseEntity update(@RequestBody Issuetype issuetype)
	{
		try {
			return new ResponseEntity<>(its.updateIssuetype(issuetype),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/api/issuetypes/{id}")
	public ResponseEntity findIssuetype(@PathVariable("id") String id)
	{
		try {
			return new ResponseEntity<>(its.getIssuetypeById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@DeleteMapping("/api/issuetypes/{id}")
	public ResponseEntity removeIssuetype(@PathVariable String id)
	{
		try {
			its.deleteIssuetypeById(id);
			return new ResponseEntity<>("Issuetype SuccessFullyDeleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/api/issuetypes")
	public ResponseEntity<Object> findAllIssuetype()
	{
		try {
			return new ResponseEntity<>(its.getAllIssuetypes(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
}
