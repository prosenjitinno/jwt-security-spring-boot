package com.prosenjit.security.jwtsecurityspringboot.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken{

	private String token;

	
	public String getToken() {
		return token;
	}

	public JwtAuthenticationToken(String token) {
		super(null, null);
		// TODO Auto-generated constructor stub
		this.token = token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
//		return super.getCredentials();
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
//		return super.getPrincipal();
		return null;
	}
	
}
