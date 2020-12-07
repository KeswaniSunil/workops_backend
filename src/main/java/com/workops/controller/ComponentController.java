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
import com.workops.model.Component;
import com.workops.service.ComponentService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ComponentController {

	@Autowired
	ComponentService componentservice;
	
	@PostMapping("/api/components")
	public ResponseEntity create(@RequestBody Component component) 
	{
		try {
//			System.out.println("com="+component);
			return new ResponseEntity<>(componentservice.createComponent(component),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	@PutMapping("/api/components/{id}")
	public ResponseEntity update(@RequestBody Component component)
	{
		try {
			return new ResponseEntity<>(componentservice.updateComponent(component),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/components/{id}")
	public ResponseEntity findComponent(@PathVariable String id)
	{
		System.out.println("component="+id);
		try {
			return new ResponseEntity<>(componentservice.getComponentById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@GetMapping("/api/components/projects/{projectid}")
	public ResponseEntity findComponentByProjectId(@PathVariable String projectid)
	{
		try {
			return new ResponseEntity<>(componentservice.getAllComponentByProjectId(projectid),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@DeleteMapping("/api/components/{cid}")
	public ResponseEntity removeComponenet(@PathVariable String cid)
	{
		try {
//			System.out.println("cid= "+cid);
			componentservice.deleteComponentById(cid);
			return new ResponseEntity<>("Component SuccessFully Deleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
	@GetMapping("/api/components")
	public ResponseEntity<Object> findAllComponent()
	{
		try {
				return new ResponseEntity<>(componentservice.getAllComponents(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}	
	}
}
