package com.todo.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.model.Address;
import com.todo.model.Users;
import com.todo.repository.AddressRepository;
import com.todo.repository.UserRepository;
import com.todo.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	UserRepository userRepo;

	@Override
	public Address saveAddress(Address address) {
		Users user = new Users();
		user = address.getUser();
		user = userRepo.findByUserId(user.getUserId());
		address.setUser(user);
		address = addressRepository.save(address);
		return address;
	}

}
