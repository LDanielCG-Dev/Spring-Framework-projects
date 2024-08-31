package com.danieh.users.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danieh.users.entities.User;
import com.danieh.users.entities.UserInRole;

@Repository
public interface UserInRoleRepository extends CrudRepository<UserInRole, Integer> {

	@Query("SELECT u FROM UserInRole u WHERE u.role.id=?1")
	public List<UserInRole> findAllUsersByRoleId(Integer roleId);

	@Query("SELECT u.user FROM UserInRole u WHERE u.role.name=?1")
	public List<User> findUserByRole(String roleName);
	
	public List<UserInRole> findByUser(User user);
	
}
