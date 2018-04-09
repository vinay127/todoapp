package com.todo.service;

import com.todo.model.Users;

public interface UserService {

	public Users getUser(long Id);

	public Users getUserByEmailAndPassword(String email, String password);

	public Users saveUser(Users user);

	public Users validateUser(String email, String password);

}
