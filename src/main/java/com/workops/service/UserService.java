package com.workops.service;

import org.springframework.stereotype.Service;

import com.workops.exception.AuthException;
import com.workops.model.User;
import com.workops.pojo.JwtToken;
import com.workops.pojo.UserEmail;

public interface UserService {

	JwtToken signin(User user);
	JwtToken signup(User user);
	String changePassword(User user) throws AuthException ;
	JwtToken generateJwtToken(User user);
	UserEmail getUser(String email);
}
