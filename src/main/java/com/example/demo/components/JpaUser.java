package com.example.demo.components;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
public class JpaUser {

	@Id
	private Long id;
	private String username;
	private String password;
	private String authority;
	
	public JpaUser()
	{
		
	}
	
	
	public JpaUser(Long id, String username, String password, String authority) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authority = authority;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "JpaUser [id=" + id + ", username=" + username + ", password=" + password + ", authority=" + authority
				+ "]";
	}
	

	
}
