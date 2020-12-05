package com.workops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workops.model.Projectteam;
import com.workops.model.ProjectteamPK;
import com.workops.service.ProjectteamService;

@RestController
public class ProjectteamController {

	
	@Autowired
	ProjectteamService pts;
	
	@PostMapping("/api/projectteams")
	public ResponseEntity create(@RequestBody Projectteam projectteam) 
	{
		try {
			ObjectMapper mapper = new ObjectMapper();
		      //Converting the Object to JSONString
		      String jsonString = mapper.writeValueAsString(projectteam);
		      System.out.println(jsonString);
			return new ResponseEntity<>(pts.createProjectteam(projectteam),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
//	@GetMapping("/api/projectteams/{id}")
//	public ResponseEntity findProject(@RequestBody ProjectteamPK ptid)
//	{
//		try {
//			return new ResponseEntity<>(pts.getProjectteamById(ptid),HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
//		}	
//	}
	@GetMapping("/api/projectteams/{id}")
	public ResponseEntity findProject(@PathVariable("id") String id)
	{
		try {
			return new ResponseEntity<>(pts.getProjectteamByProjectId(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@DeleteMapping("/api/projectteams/{id}")
	public ResponseEntity deleteProjectById(@PathVariable("id") String id)
	{
		try {
			pts.deleteProjectteamByProjectId(id);
			return new ResponseEntity<>("Porject Deleted Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@DeleteMapping("/api/projectteams/{pid}/{eid}")
	public ResponseEntity deleteProjectByKey(@PathVariable("pid") String pid,@PathVariable("eid") String eid)
	{
		System.out.println("innnn");
		try {
			pts.deleteProjectteamByEmail(new ProjectteamPK(pid,eid));
			return new ResponseEntity<>("Project Deleted Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
}
