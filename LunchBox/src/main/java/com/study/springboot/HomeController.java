package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "main";
	}
	
	@PostMapping("/")
	public String home1() {
		return "main";
	}
}
