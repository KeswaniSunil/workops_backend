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

import com.workops.model.Componentissue;
import com.workops.service.ComponentissueService;

@RestController
public class ComponentissueController {

	@Autowired
	ComponentissueService compservice;
	
	@PostMapping("/api/componentissue")
	public ResponseEntity create(@RequestBody Componentissue componentissue) 
	{
		try {
//			ObjectMapper mapper = new ObjectMapper();
//		      //Converting the Object to JSONString
//		      String jsonString = mapper.writeValueAsString(projectteam);
//		      System.out.println(jsonString);
			return new ResponseEntity<>(compservice.createComponentIssue(componentissue),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/api/componentissue/{compid}")
	public ResponseEntity getIssues(@PathVariable("compid") String compid) 
	{
		try {
			List<String>issueids=compservice.getAllIssueIds(compid);
//			System.out.println("pro="+issueids.size()+" "+issueids);
			if(issueids.size()>0)
			return new ResponseEntity<>(compservice.getAllIssuesByComponentId(issueids),HttpStatus.OK);
			else
				return new ResponseEntity<>("No Issues in the Given Component",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	
	@DeleteMapping("/api/componentissue/{cid}/{issueid}")
	public ResponseEntity deleteComponentIssueByKey(@PathVariable("cid") String cid,@PathVariable("issueid") String issueid)
	{
//		System.out.println("innn "+email+" "+pid);
		try {
//			pts.deleteProjectteamByEmailAndProjectId(pid,email);
			compservice.deleteComponentissueByComponentIdAndIssueId(cid, issueid);
			return new ResponseEntity<>("Component Deleted Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
}
