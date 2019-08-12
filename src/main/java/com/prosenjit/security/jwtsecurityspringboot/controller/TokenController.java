package com.prosenjit.security.jwtsecurityspringboot.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prosenjit.security.jwtsecurityspringboot.model.JwtUser;
import com.prosenjit.security.jwtsecurityspringboot.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

	private JwtGenerator jwtGenerator;
	
	public TokenController (JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}
	
	@RequestMapping
	public String generateToken(@RequestBody JwtUser jwtUser) {
		return jwtGenerator.generate(jwtUser);
	}
}
