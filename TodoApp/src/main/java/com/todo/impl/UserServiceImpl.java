package com.todo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.exception.NotificationType;
import com.todo.exception.TodoException;
import com.todo.exception.TransactionalInfo;
import com.todo.model.Users;
import com.todo.repository.UserRepository;
import com.todo.service.AuthenticationTokenService;
import com.todo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	Users user = new Users();

	@Autowired
	UserRepository userRepo;

	@Autowired
	AuthenticationTokenService authenticationTokenService;

	TransactionalInfo transactionalInfo = new TransactionalInfo();

	@Override
	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		userValidation(user);
		user = userRepo.save(user);
		return user;
	}

	public void userValidation(Users user) throws TodoException {
		if (user.getUserName() == null) {
			transactionalInfo.generateException("User name cant be empty", 500, NotificationType.ERROR);
		}
	}

	@Override
	public Users validateUser(String email, String password) {
		user = userRepo.findByEmailAndPassword(email, password);
		if (user != null) {
			authenticationTokenService.geneateAuthToken(user.getUserId());
		}
		return user;
	}

	@Override
	public Users getUser(long Id) {
		return userRepo.findByUserId(Id);
	}

	@Override
	public Users getUserByEmailAndPassword(String email, String password) {
		user = userRepo.findByEmailAndPassword(email, password);
		return user;
	}
}
