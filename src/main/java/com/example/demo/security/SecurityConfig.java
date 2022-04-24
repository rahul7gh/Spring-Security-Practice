package com.example.demo.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.savedrequest.NullRequestCache;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http
 		.csrf()
 		.disable()
 		
 		.sessionManagement()
 		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
 
 		.and()
 		.authorizeRequests()
 		.anyRequest()
 		.authenticated()
 		.and()
 		.httpBasic();
 	}

 	

	
	

}
