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
		http.httpBasic(
				
				c-> c.authenticationEntryPoint(new CustomAuthEntryPoint())
				
				);
		http.sessionManagement().sessionCreationPolicy
		(SessionCreationPolicy.STATELESS);		
		System.out.println("Yarr Bhai! Ayyyy bho!!");
		http.authorizeRequests().antMatchers("/unauth*").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		
	}
	
	
	
	
}
