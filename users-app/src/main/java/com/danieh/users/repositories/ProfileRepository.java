package com.danieh.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danieh.users.entities.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

}
