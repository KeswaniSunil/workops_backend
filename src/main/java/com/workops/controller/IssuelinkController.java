package com.workops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workops.model.Issuelink;
import com.workops.service.IssuelinkService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class IssuelinkController {

	
	@Autowired
	IssuelinkService ils;
	
	@PostMapping("/api/issuelinks")
	public ResponseEntity create(@RequestBody Issuelink Issuelink) 
	{
		try {
//			ObjectMapper mapper = new ObjectMapper();
//		      //Converting the Object to JSONString
//		      String jsonString = mapper.writeValueAsString(Issuelink);
//		      System.out.println(jsonString);
			return new ResponseEntity<>(ils.createIssuelink(Issuelink),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
//	@GetMapping("/api/Issuelinks/{id}")
//	public ResponseEntity findProject(@RequestBody IssuelinkPK ptid)
//	{
//		try {
//			return new ResponseEntity<>(ils.getIssuelinkById(ptid),HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
//		}	
//	}
	@GetMapping("/api/Issuelinks/{name}")
	public ResponseEntity findIssuelink(@PathVariable("name") String name)
	{
		try {
			return new ResponseEntity<>(ils.getIssuelinkByName(name),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@DeleteMapping("/api/issuelinks/{name}")
	public ResponseEntity deleteIssuelinkByName(@PathVariable("name") String name)
	{
		try {
			ils.deleteIssuelinkByName(name);
			return new ResponseEntity<>("Porject Deleted Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@DeleteMapping("/api/issuelinks/{pid}/{cid}")
	public ResponseEntity deleteIssuelinkByKey(@PathVariable("pid") String pid,@PathVariable("cid") String cid)
	{
		System.out.println("innnn");
		try {
			ils.deleteIssuelinkByParentIssueAndChildIssue(pid, cid);
			return new ResponseEntity<>("Isslue Deleted Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}

}
