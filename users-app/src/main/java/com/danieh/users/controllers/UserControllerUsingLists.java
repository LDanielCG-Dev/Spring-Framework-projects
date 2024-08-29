package com.danieh.users.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danieh.users.models.User;
import com.danieh.users.services.UserServiceUsingLists;

@RestController
//Definicion de mi recurso
@RequestMapping("/v1/users")
public class UserControllerUsingLists {
	
	Logger log = LoggerFactory.getLogger(UserControllerUsingLists.class);
	
	@Autowired
	private UserServiceUsingLists userService;
	
	@GetMapping
	//Metodo HTTP + Recurso -> Handler methods
	 /* 
	 * /v1/users?startWith=da
	 */
	public ResponseEntity<List<User>> getUsers(@RequestParam(value = "startWith", required = false) String startWith) {
		log.info("Get list of users.");
		return new ResponseEntity<List<User>>(userService.getUsers(startWith), HttpStatus.OK);
	}
	/*
	 * Path param
	 * danieh.com/users/amogus/emails/10
	 * 
	 * Dame el email con id 10 de amogus
	 * 
	 * Query params
	 * danieh.com/users/amogus/emails?startDate=19-08-2019&endDate=20-08-2019
	 */
	@GetMapping(value = "/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
		log.info("Get user by Username {}.", username);
		return new ResponseEntity<User>(userService.getUserByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		log.info("Create user {}", user.getUsername());
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user) {
		log.info("Update user {}", username);
		return new ResponseEntity<User>(userService.updateUser(user, username), HttpStatus.OK);
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username) {
		log.info("Delete user {}", username);
		userService.deleteUser(username);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
