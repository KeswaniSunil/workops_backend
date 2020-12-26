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

import com.workops.exception.ErrorDetails;
import com.workops.model.Version;
import com.workops.service.VersionService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class VersionController {

	@Autowired
	VersionService Versionservice;
	
	@PostMapping("/api/versions")
	public ResponseEntity create(@RequestBody Version Version) 
	{
		try {
			return new ResponseEntity<>(Versionservice.createVersion(Version),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/api/versions")
	public ResponseEntity update(@RequestBody Version Version)
	{
		try {
			return new ResponseEntity<>(Versionservice.updateVersion(Version),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/api/versions/{id}")
	public ResponseEntity findVersion(@PathVariable String id)
	{
		System.out.println("Version="+id);
		try {
			return new ResponseEntity<>(Versionservice.getVersionById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/api/versions/projects/{projectid}")
	public ResponseEntity findVersionByProjectId(@PathVariable String projectid)
	{
		try {
			return new ResponseEntity<>(Versionservice.getAllVersionByProjectId(projectid),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@DeleteMapping("/api/versions/{vid}")
	public ResponseEntity removeVersion(@PathVariable String vid)
	{
		try {
			Versionservice.deleteVersionById(vid);
			return new ResponseEntity<>("Version SuccessFully Deleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/api/versions")
	public ResponseEntity<Object> findAllVersion()
	{
		try {
				return new ResponseEntity<>(Versionservice.getAllVersions(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
}
