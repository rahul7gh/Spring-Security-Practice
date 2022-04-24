package com.example.demo.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


@Component
public class CustomUserDetails implements UserDetails{

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> auths=new ArrayList<>();
//		auths.add( ()->"READ" );
//		return Collections.singletonList(new SimpleGrantedAuthority("Read"));
		return List.of(()->"READ");
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return "12345";
	}

	@Override
	public String getUsername() {
		
		return "bill";
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
