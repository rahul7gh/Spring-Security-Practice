package com.example.demo.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class JdbcUserDetails implements UserDetails {
	
	JpaUser jpaUser;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths= new ArrayList<>();
		auths.add(() -> this.jpaUser.getAuthority());
		
		return auths;
	}

	@Override
	public String getPassword() {
		
		return this.jpaUser.getPassword();
	}

	@Override
	public String getUsername() {
		
		return this.jpaUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

	
}
