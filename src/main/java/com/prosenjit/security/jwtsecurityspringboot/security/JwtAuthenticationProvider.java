package com.prosenjit.security.jwtsecurityspringboot.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.prosenjit.security.jwtsecurityspringboot.model.JwtAuthenticationToken;
import com.prosenjit.security.jwtsecurityspringboot.model.JwtUser;
import com.prosenjit.security.jwtsecurityspringboot.model.JwtUserDetails;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{

	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
	}

	@Autowired
	JwtValidator validator;
	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken)usernamePasswordAuthenticationToken;
		String token = jwtAuthenticationToken.getToken();
		
		JwtUser jwtUser = validator.validate(token);
		
		if (jwtUser == null) {
			throw new RuntimeException("Jwt Token is incorrect");
		}
		
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(jwtUser.getRole());
		
		return new JwtUserDetails(jwtUser.getUserName(), token,
				jwtUser.getId(),
				grantedAuthorities);
		
	}
	
}
