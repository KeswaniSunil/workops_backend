package com.workops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workops.model.User;
import com.workops.model.UserOtp;
import com.workops.pojo.Otp;
import com.workops.service.UserOtpService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserOtpController {
	
	@Autowired
	UserOtpService userOtpService;
	
	@PostMapping("/api/otp")
	public ResponseEntity<?> generate(@RequestBody UserOtp userOtp)
	{
		try
		{

			return new ResponseEntity<>(userOtpService.generate(userOtp),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/api/otp/check")
	public ResponseEntity checkOtp(@RequestBody String email)
	{
		try
		{
			return new ResponseEntity<>(userOtpService.checkOtp(email),HttpStatus.OK);	
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
