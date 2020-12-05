package com.workops.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.UserOtp;


public interface UserOtpDao extends JpaRepository <UserOtp,String> {
	public Optional<UserOtp> findByEmail(String email);
}
