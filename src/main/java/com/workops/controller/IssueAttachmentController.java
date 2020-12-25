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

import com.workops.model.Issueattachment;
import com.workops.service.IssueattachmentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class IssueAttachmentController {
	@Autowired
	IssueattachmentService iservice;
	
	@PostMapping("/api/issueattachments")
	public ResponseEntity create(@RequestBody Issueattachment iattach) 
	{
		try {
			return new ResponseEntity<>(iservice.createIssueAttachment(iattach),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/api/issueattachments/")
	public ResponseEntity update(@RequestBody Issueattachment iattach)
	{
		try {
			return new ResponseEntity<>(iservice.updateIssueattachment(iattach),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/api/issueattachments/{id}")
	public ResponseEntity findProject(@PathVariable("id") String id)
	{
		try {
			return new ResponseEntity<>(iservice.getIssueAttachmentById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@DeleteMapping("/api/issueattachments/{id}")
	public ResponseEntity removeProject(@PathVariable String id)
	{
		try {
			iservice.deleteIssueAttachmentById(id);
			return new ResponseEntity<>("IssueAttachment SuccessFullyDeleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/api/issueattachments")
	public ResponseEntity<Object> findAllProject()
	{
		try {
			return new ResponseEntity<>(iservice.getAllIssueattachments(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
}
