package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConifg {

	@Bean
	public UserDetailsService userDetailsService()
	{
		List<UserDetails> users= new ArrayList<>();
		users.add(User.withUsername("rahul1").password("rahul")
				.authorities("read").build());
		UserDetailsService userDetailsService=
				new InMemoryUserDetailsManager(users);
		
		return userDetailsService;
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
}
