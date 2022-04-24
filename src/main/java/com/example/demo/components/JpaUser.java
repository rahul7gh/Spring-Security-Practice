package com.example.demo.components;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class JpaUser {

	@Id
	private Long id;
	private String username;
	private String password;
	private boolean enabled;
	
	public JpaUser()
	{
		
	}
	
	
	public JpaUser(Long id, String username, String password, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
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
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "JpaUser [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ "]";
	}
	

	
}
