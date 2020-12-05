package com.workops.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="userotp")
public class UserOtp {
	
	@Column(name="email")
	@Id
	private String email;
	
	@Column(name="otp")
	private int otp;
	
	@Column(name="otptime")
	private LocalDateTime otpTime;
	
	@OneToOne
	@JoinColumn(name="email")
	private User user;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public LocalDateTime getOtpTime() {
		return otpTime;
	}

	public void setOtpTime(LocalDateTime otpTime) {
		this.otpTime = otpTime;
	}

	public UserOtp() {
	}
}
