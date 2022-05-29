package com.example.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

//@Component
public class CustomAuthEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.addHeader("Custom Header", "Mand hai kya bhay?");
		response.sendError(HttpStatus.UNAUTHORIZED.value());
		
		/*
		 * go to your configure method and add this to customizer and pass to httpBasic
		 * method;
		 * Alos note that Spring is not expecting this as Bean so simply putting
		 * a Component annotation instead of passsing it to HttpBasic torugh a 
		 * customizer will not work!
		 */
		
	}
	
}
