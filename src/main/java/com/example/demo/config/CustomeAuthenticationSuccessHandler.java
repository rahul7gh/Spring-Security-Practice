package com.example.demo.config;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomeAuthenticationSuccessHandler 
implements AuthenticationSuccessHandler
{
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Optional<? extends GrantedAuthority> auth=
				authentication.getAuthorities().stream()
		.filter(s->s.getAuthority().equals("WRITE")).findAny();
		System.out.println(auth);
		if(auth.isPresent())
		{
			response.sendRedirect("/home");
		}
		else
		{
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.sendRedirect("/unauthorized");
		}
		
	}
}
