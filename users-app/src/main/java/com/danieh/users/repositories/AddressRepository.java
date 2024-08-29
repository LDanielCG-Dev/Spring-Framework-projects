package com.danieh.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danieh.users.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
