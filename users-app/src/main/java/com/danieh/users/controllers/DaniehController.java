package com.danieh.users.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Stereotype
@RequestMapping("/hello")
public class DaniehController {

	private static final Logger log = LoggerFactory.getLogger(DaniehController.class);
	
	@GetMapping
	public String helloWorld() {
		log.info("Request received.");
		return "¡ Hello World !";
	}
}
