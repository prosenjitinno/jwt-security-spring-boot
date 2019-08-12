package com.prosenjit.security.jwtsecurityspringboot.security;

import org.springframework.stereotype.Component;

import com.prosenjit.security.jwtsecurityspringboot.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	public String generate(JwtUser jwtUser) {
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getUserName());
		
		claims.put("UserId", String.valueOf(jwtUser.getId()));
		claims.put("role", String.valueOf(jwtUser.getRole()));
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, "YouTube")
				.compact();
	}
}
