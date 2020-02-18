package com.azad.practice.housecostbackend.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
public class PersonController {

	@GetMapping
	public String helloWorldTest() {
		return "hello! world";
	}
}
