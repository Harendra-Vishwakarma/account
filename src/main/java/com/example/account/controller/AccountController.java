package com.example.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@GetMapping("/get")
	public String get() {
		return "this is rest controller";
	}


	@GetMapping("/")
	public String getHome() {
		return "this is home controller";
	}
}
