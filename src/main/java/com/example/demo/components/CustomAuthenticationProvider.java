package com.example.demo.components;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/*
 * We have a component class meaning spring boot will automatically insatntiate its' oobject using dfault 
 * constructor.
 * the authenticate method hold the logic of when to return succcess response and when to throw Exceptons.
 * ****Note that in ProjectConfig class we still have our two beans avilable but we have not used them in our own authenticationflow.
 * we'll do this later.
 * 
 */

//@Component
public class CustomAuthenticationProvider
//implements AuthenticationProvider
{

//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		String username= authentication.getName();
//		String password= String.valueOf(authentication.getCredentials());
//		
//		
//		System.out.println(username+" "+password);
//		if(username.equals("ayo") && password.equals("lol"))
//		{
//			return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList()); 
//		}
//		
//		throw new AuthenticationCredentialsNotFoundException("Ky yarr hai!");
//	}
//	@Override
//	public boolean supports(Class<?> authentication) {
//
//		return UsernamePasswordAuthenticationToken.class
//				.isAssignableFrom(authentication);
//	}
}

