package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefController {
	
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
	

}
