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

import com.example.demo.components.CustomUserDetails;

@Configuration
public class UserManagementConifg {

	@Bean
	public UserDetailsService userDetailsService()
	{
		UserDetails user1=new CustomUserDetails("gg","plox");
		UserDetails user2=new CustomUserDetails("rahul","pohare");
		UserDetails user3=new CustomUserDetails("anket","rindhe");
		
		List<UserDetails> list=List.of(user1,user2,user3);
		
		UserDetailsService userDetailsService= 
				new InMemoryUserDetailsManager(list);
		
		return userDetailsService;
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
}
