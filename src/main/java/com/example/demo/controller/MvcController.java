package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/*This is controller and not RestController othewrise values returned would be sent as
body of response.
so whatever you return is called a view which will be rendered as response.
you can even pass data to view.(Not done here!).
*/
@Controller
public class MvcController {
	
	@GetMapping("/home")
	public String getHomePage()
	{
		return "home.html";
	}
	
	@GetMapping("/unauthorized")
	public String getUnAUthView()
	{
		return "unauthorized.html";
	}
}
