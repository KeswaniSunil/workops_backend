package com.workops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.workops.service.DashboardService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DashboardController {

	@Autowired
	DashboardService dashboardService;
	
	@GetMapping("/api/dashboard/{pid}")
	public ResponseEntity getDashboardData(@PathVariable String pid)
	{
		try {
			return new ResponseEntity<>(dashboardService.getDashboardData(pid),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
}
