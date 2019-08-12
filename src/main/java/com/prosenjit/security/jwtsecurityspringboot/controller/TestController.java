package com.prosenjit.security.jwtsecurityspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/controller")
	public String testApp() {
		return "Test App is working";
	}
}
