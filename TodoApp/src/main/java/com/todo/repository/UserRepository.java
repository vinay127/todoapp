package com.todo.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.codetype.StatusCode;
import com.todo.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Serializable> {

	public Users findByUserId(long Id);

	public List<Users> findByUserName(String userName);

	public List<Users> findByUserNameAndEmail(String userName, String email);
	
	public List<Users> findByCreatedDateTimeAfterAndStatus(Date createdDateTime, StatusCode status);
	
	public Users findByEmailAndPassword(String email, String password);

}
