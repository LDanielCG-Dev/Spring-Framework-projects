package com.danieh.users.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danieh.users.entities.Role;
import com.danieh.users.entities.User;
import com.danieh.users.entities.UserInRole;
import com.danieh.users.services.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService service;
	
	private static final Logger log = LoggerFactory.getLogger(RoleController.class);
	
	@GetMapping
	public ResponseEntity<List<Role>> getRoles() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("Name {}", authentication.getName());
		log.info("Principal {}", authentication.getPrincipal());
		log.info("Credentials {}", authentication.getCredentials());
		log.info("Authorities {}", authentication.getAuthorities().toString());
		return new ResponseEntity<List<Role>>(service.getRoles(), HttpStatus.OK);
	}
	
	@GetMapping("/{roleName}/users")
	public ResponseEntity<List<User>> getUsersByRole(@PathVariable("roleName") String roleName) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("Name {}", authentication.getName());
		log.info("Principal {}", authentication.getPrincipal());
		log.info("Credentials {}", authentication.getCredentials());
		log.info("Authorities {}", authentication.getAuthorities().toString());
		return new ResponseEntity<List<User>>(service.getUsersByRole(roleName), HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<Role> createRoles(@RequestBody Role role) {
		return new ResponseEntity<Role>(service.createRole(role), HttpStatus.CREATED);
	}
	
	@PutMapping("/{roleId}")
	public ResponseEntity<Role> updateRoles(@PathVariable("roleId") Integer roleId, @RequestBody Role role) {
		return new ResponseEntity<Role>(service.updateRole(roleId, role), HttpStatus.OK);
	}
	
	@DeleteMapping("/{roleId}")
	public ResponseEntity<Void> deleteRole(@PathVariable("roleId") Integer roleId) {
		service.deleteRole(roleId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	@PostMapping("/assign")
	public ResponseEntity<UserInRole> roleAssignment(@RequestBody UserInRole userInRole) {
		return new ResponseEntity<UserInRole>(service.roleAssignment(userInRole), HttpStatus.CREATED);
	}
	
	
	/* OLD Endpoint
	@GetMapping("/{roleId}/users")
	public ResponseEntity<List<UserInRole>> findUsersByRoleId(@PathVariable("roleId") Integer roleId) {
		return new ResponseEntity<List<UserInRole>>(service.findUsersByRoleId(roleId), HttpStatus.OK);
	}
	*/
	
}
