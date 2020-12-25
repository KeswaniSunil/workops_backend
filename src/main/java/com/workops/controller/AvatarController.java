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

import com.workops.model.Avatar;
import com.workops.service.AvatarService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AvatarController {
	@Autowired
	AvatarService ats;
	
	@PostMapping("/api/avatars")
	public ResponseEntity create(@RequestBody Avatar avatar) 
	{
		try {
//			System.out.println("com="+component);
			return new ResponseEntity<>(ats.createAvatar(avatar),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/api/avatars/{id}")
	public ResponseEntity update(@RequestBody Avatar avatar)
	{
		try {
			return new ResponseEntity<>(ats.updateAvatar(avatar),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/api/avatars/{id}")
	public ResponseEntity findAvatar(@PathVariable("id") String id)
	{
		try {
			return new ResponseEntity<>(ats.getAvatarById(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@DeleteMapping("/api/avatars/{id}")
	public ResponseEntity removeAvatar(@PathVariable String avatarid)
	{
		try {
			ats.deleteAvatarId(avatarid);
			return new ResponseEntity<>("Component SuccessFully Deleted",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}
	@GetMapping("/api/avatars")
	public ResponseEntity<Object> findAllAvatar()
	{
		try {
			return new ResponseEntity<>(ats.getAllAvatars(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}	
	}

}
