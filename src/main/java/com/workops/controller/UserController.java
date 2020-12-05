package com.workops.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workops.dao.UserDao;
import com.workops.model.User;
import com.workops.pojo.JwtToken;
import com.workops.service.UserService;
//import com.workops.pojo.JwtToken;
//import com.workops.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/api/signup")
	public ResponseEntity signup(@RequestBody User user)
	{
		try
		{
			return new ResponseEntity<>(userService.signup(user),HttpStatus.OK);	
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/api/signin")
	public ResponseEntity signin(@RequestBody User user)
	{
		try
		{
	
			return new ResponseEntity(userService.signin(user),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(e.getMessage().toString(),HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/api/changepassword")
	public ResponseEntity changePassword(@RequestBody User user)
	{
		try
		{
			return new ResponseEntity(userService.changePassword(user),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(e.getMessage().toString(),HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/api/user/{token}")
	public ResponseEntity getUserByToken(@PathVariable String token)
	{
		try
		{
	
			return new ResponseEntity(userService.getUser(token),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity(e.getMessage().toString(),HttpStatus.BAD_REQUEST);
		}
	}
	
}
