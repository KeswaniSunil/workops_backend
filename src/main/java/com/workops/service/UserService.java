package com.workops.service;

import org.springframework.stereotype.Service;

import com.workops.model.User;
import com.workops.pojo.JwtToken;

public interface UserService {

	JwtToken signin(User user);
	JwtToken signup(User user);
	JwtToken generateJwtToken(User user);
}
