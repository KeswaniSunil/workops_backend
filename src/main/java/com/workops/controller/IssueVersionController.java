package com.workops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workops.model.Issueversion;
import com.workops.service.IssueversionService;

@RestController
public class IssueVersionController {

	@Autowired
	IssueversionService ivservice;
	
	@PostMapping("/api/issueversion")
	public ResponseEntity creatIssueVerison(@RequestBody Issueversion issueversion) 
	{
		try {
			return new ResponseEntity<>(ivservice.createIssueVersion(issueversion),HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/api/issueversion/{ivid}")
	public ResponseEntity getIssues(@PathVariable("ivid") String ivid) 
	{
		try {
			List<String>issueids=ivservice.getAllIssueIds(ivid);
			System.out.println("pro="+issueids.size()+" "+issueids);
			if(issueids.size()>0)
				return new ResponseEntity<>(ivservice.getAllIssuesByVersionId(issueids),HttpStatus.OK);
			else
				return new ResponseEntity<>("No Issues in the Given Component",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}

	@DeleteMapping("/api/issueversion/{vid}/{issueid}")
	public ResponseEntity deleteIssueVersionByKey(@PathVariable("vid") String vid,@PathVariable("issueid") String issueid)
	{
		try {
			ivservice.deleteIssueversionByVersionIdAndIssueId(vid, issueid);
			return new ResponseEntity<>("Issue Version Deleted Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	
}
