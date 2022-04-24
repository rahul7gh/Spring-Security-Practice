package com.example.demo.components;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="authorities")
public class JpaAuthority {
@Id
Long id;

String authority;

public JpaAuthority()
{
	
}

public JpaAuthority(Long id, String authority) {
	super();
	this.id = id;
	this.authority = authority;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getAuthority() {
	return authority;
}

public void setAuthority(String authority) {
	this.authority = authority;
}

@Override
public String toString() {
	return "JpaAuthority [id=" + id + ", authority=" + authority + "]";
}

	
}
