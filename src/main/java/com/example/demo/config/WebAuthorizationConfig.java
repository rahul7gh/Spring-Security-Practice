package com.example.demo.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
public class WebAuthorizationConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic(
//				
//				c-> c.authenticationEntryPoint(new CustomAuthEntryPoint())
//				
//				);
		
		http.formLogin()
		
		//defualt path after succesfull login.You can aceiev same by passing
		// a cusomizer lambda to the formLogin.
		
//		.defaultSuccessUrl("/home",false);
		
		
		
//		This is very general approach so for any succesfully logged in user
//		this view will be rendered. a more customed approach can be achevies 
//		via AUthennticationSuccessHnadler bean which can be customized to rneder
//		different views based on different attributes of logged in user such as
//		authorites, etc.
		.successHandler(new CustomeAuthenticationSuccessHandler());
		
//		similar to this you can also have failedLoginHnadler.
//		also if you want to have both httpbasic and formlogin you can have it,
		
		/*
		 * Using stateless with formlogin is just a pure blunder. statless means there
		 * is nothing associated with request to identify whether a user is the same who
		 * sent previous requests or a new one. so any request you make in ststkess will
		 * redirect you to login page
		 */
//		http.sessionManagement().sessionCreationPolicy
//		(SessionCreationPolicy.STATELESS);		
		
		System.out.println("Yarr Bhai! Ayyyy bho!!");
		http.authorizeRequests().antMatchers("/unauth*").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		
	}
	
	
	
	
}
