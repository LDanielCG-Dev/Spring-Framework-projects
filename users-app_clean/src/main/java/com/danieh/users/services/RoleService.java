package com.danieh.users.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.danieh.users.entities.Role;
import com.danieh.users.entities.User;
import com.danieh.users.entities.UserInRole;
import com.danieh.users.models.AuditDetails;
import com.danieh.users.models.DaniehSecurityRule;
import com.danieh.users.repositories.RoleRepository;
import com.danieh.users.repositories.UserInRoleRepository;
import com.danieh.users.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@DaniehSecurityRule
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserInRoleRepository userInRoleRepository;

	@Autowired
	private KafkaTemplate<Integer, String> kafkaTemplate;

	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private UserRepository userRepository;

	private static final Logger log = LoggerFactory.getLogger(RoleService.class);

	// @Secured({"ROLE_ADMIN"})
	// @RolesAllowed({"ROLE_ADMIN"})
	public List<User> getUsersByRole(String roleName) {
		log.info("Getting roles by name {}", roleName);
		return userInRoleRepository.findUserByRole(roleName);
	}

	public List<Role> getRoles() {
		return roleRepository.findAll();
	}

	public Role createRole(Role role) {
		Role roleCreated = roleRepository.save(role);

		AuditDetails details = new AuditDetails(SecurityContextHolder.getContext().getAuthentication().getName(),
				role.getName());

		try {
			kafkaTemplate.send("danieh-topic", mapper.writeValueAsString(details));
		} catch (JsonProcessingException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error parsing the message.");
		}

		return roleCreated;
	}

	public Role updateRole(Integer roleId, Role role) {
		Optional<Role> result = roleRepository.findById(roleId);
		if (result.isPresent()) {
			return roleRepository.save(role);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exist.", roleId));
		}
	}

	public void deleteRole(Integer roleId) {
		Optional<Role> result = roleRepository.findById(roleId);
		
		if (result.isPresent()) {
			List<UserInRole> usersWithRoleToBeDeleted = userInRoleRepository.findAllUsersByRoleId(roleId);
			
			if (usersWithRoleToBeDeleted != null && !usersWithRoleToBeDeleted.isEmpty()) {
				userInRoleRepository.deleteAll(usersWithRoleToBeDeleted);
			} else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with role %d don't exist.", roleId));
			}
			
			roleRepository.delete(result.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Role id %d doesn't exist.", roleId));
		}
	}

	public void deleteRoleFromUser(User user) {
		List<UserInRole> result = userInRoleRepository.findByUser(user);

		if (result != null && !result.isEmpty()) {
			userInRoleRepository.deleteAll(result);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found in repository.", user));
		}
	}

	public UserInRole roleAssignment(UserInRole userInRole) {
		Integer userId = userInRole.getUser().getId();
		Integer roleId = userInRole.getRole().getId();

		Optional<User> user = userRepository.findById(userId);
		Optional<Role> role = roleRepository.findById(roleId);

		if (user.isPresent() && role.isPresent()) {
			userInRole.setUser(user.get());
			userInRole.setRole(role.get());
			return userInRoleRepository.save(userInRole);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("User %d and role %d not found.", userId, roleId));
		}
	}

	public List<UserInRole> findUsersByRoleId(Integer roleId) {
		return userInRoleRepository.findAllUsersByRoleId(roleId);
	}

}
