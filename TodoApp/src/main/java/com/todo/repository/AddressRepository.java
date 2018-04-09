package com.todo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.model.Address;
import com.todo.model.Users;

@Repository
public interface AddressRepository extends JpaRepository<Address, Serializable> {

	public List<Address> findByAddressId(long addressId);
	
	public List<Address> findByAddressIdAndUser(long addressId, Users user);

}