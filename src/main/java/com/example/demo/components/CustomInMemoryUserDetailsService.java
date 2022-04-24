package com.example.demo.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


public class CustomInMemoryUserDetailsService implements UserDetailsService {

	List<CustomUserDetails> list;
	
	public CustomInMemoryUserDetailsService()
	{
		
		list=new ArrayList<>();
		list.add(new CustomUserDetails( "rahul", "pohare"));
		list.add(new CustomUserDetails( "anket", "rindhe"));
		System.out.println("Loaded Data!");
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);	
		
		for(CustomUserDetails c: list)
		{
			if(c.getUsername().toLowerCase().toLowerCase()
				.equals(username.toLowerCase()))
				return c;
		}
	
		throw new UsernameNotFoundException(username+" does not exist!");
		
	}

	
	
}
