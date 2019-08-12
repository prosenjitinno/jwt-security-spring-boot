package com.prosenjit.security.jwtsecurityspringboot.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import com.prosenjit.security.jwtsecurityspringboot.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{


	protected JwtAuthenticationTokenFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);
		// TODO Auto-generated constructor stub
	}
	
	public JwtAuthenticationTokenFilter() {
		super("/rest/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws AuthenticationException, IOException, ServletException {
		// TODO Auto-generated method stub
		
		String header = httpServletRequest.getHeader("Authorisation");
		
		if(header == null || !header.startsWith("Token ")) {
			throw new RuntimeException("Jwt Token is missing");
		}
		
		String authenticationToken = header.substring(6);
		
		JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken); 
		
		return getAuthenticationManager().authenticate(token);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}

}
