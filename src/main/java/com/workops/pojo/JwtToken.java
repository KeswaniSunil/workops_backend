package com.workops.pojo;

public class JwtToken {
	
	private String token;
	
	public JwtToken() {
		super();
	}
	public JwtToken(String s) {
		super();
		token=s;
	}

	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
