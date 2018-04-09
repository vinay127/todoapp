package com.todo.service;

import java.util.Date;
import java.util.List;

import com.todo.codetype.StatusCode;
import com.todo.model.AuthenticationToken;
import com.todo.model.Users;

public interface AuthenticationTokenService {

	public void saveAuthenticationToken(AuthenticationToken token);

	public AuthenticationToken getByAuthId(long authId);

	public AuthenticationToken getByUser(Users user);

	public List<AuthenticationToken> getByUserAndStatus(Users user, StatusCode code);

	public List<AuthenticationToken> getByUserAndStatusAndExpiryDateTimeBefore(Users user, StatusCode code,
			Date expiryDate);

	public AuthenticationToken getByToken(String token);

	public boolean isValidToken(String token);

	public AuthenticationToken geneateAuthToken(long userId);
}
