package com.danieh.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danieh.users.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
