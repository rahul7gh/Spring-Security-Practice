package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.components.JpaAuthority;
import com.example.demo.components.JpaUser;

@RestController
public class DefController {
	
	@Autowired
	CrudRepository<JpaUser, Long> userRepository;
	
	@Autowired
	CrudRepository<JpaAuthority, Long> authRepositry;
	
	@GetMapping("/")
	public ResponseEntity<String> welcome(HttpServletRequest request,HttpServletResponse response)
	{
		return ResponseEntity.ok("Welcome Bhay!");
	}
	
	@GetMapping("/nope")
	public ResponseEntity<String> Noauth()
	{
		return ResponseEntity.ok("No Auth here Welcome Bhay!");
	}
	
	@GetMapping("/users")
	List<JpaUser> getData()
	{
		return (List<JpaUser>) userRepository.findAll();
	}
	
	@GetMapping("/auths")
	List<JpaAuthority> getAuths()
	{
		return (List<JpaAuthority>) authRepositry.findAll();
	}
}
