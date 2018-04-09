package com.todo.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.codetype.StatusCode;
import com.todo.model.AuthenticationToken;
import com.todo.model.Users;

@Repository
public interface AuthenticationTokenRepository extends JpaRepository<AuthenticationToken, Serializable> {

	public AuthenticationToken findByAuthId(long authId);

	public AuthenticationToken findByUser(Users user);

	public List<AuthenticationToken> findByUserAndStatus(Users user, StatusCode code);

	public List<AuthenticationToken> findByUserAndStatusAndExpiryDateTimeBefore(Users user, StatusCode code,
			Date expiryDate);

	public AuthenticationToken findByToken(String token);

}
