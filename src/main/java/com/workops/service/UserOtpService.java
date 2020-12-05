package com.workops.service;

import org.springframework.http.ResponseEntity;

import com.workops.model.UserOtp;
import com.workops.pojo.Otp;

public interface UserOtpService {
	Otp generate(UserOtp userOtp) throws Exception;
	String checkOtp(String email) throws Exception;
}
