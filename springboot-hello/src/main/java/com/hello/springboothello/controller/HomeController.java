package com.hello.springboothello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")		// localhost:8080 들어가면 @GetMapping("/") 호출됨
	public String home() {
		return "home";
	}
}
