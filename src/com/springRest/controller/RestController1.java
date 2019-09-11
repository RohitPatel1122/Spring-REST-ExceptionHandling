package com.springRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class RestController1 {

	@GetMapping("/hello")
	public String hello(){
		return "Hello";
	}
}
