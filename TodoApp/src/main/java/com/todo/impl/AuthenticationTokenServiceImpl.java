package com.todo.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.codetype.StatusCode;
import com.todo.model.AuthenticationToken;
import com.todo.model.Users;
import com.todo.repository.AuthenticationTokenRepository;
import com.todo.service.AuthenticationTokenService;
import com.todo.service.UserService;

@Service
@Transactional
public class AuthenticationTokenServiceImpl implements AuthenticationTokenService {

	@Autowired
	AuthenticationTokenRepository authTokenRepository;

	// AuthenticationToken authenticationToken = new AuthenticationToken();

	Users user = new Users();

	@Autowired
	UserService userService;

	@Override
	public void saveAuthenticationToken(AuthenticationToken token) {
		authTokenRepository.save(token);
	}

	@Override
	public AuthenticationToken getByAuthId(long authId) {
		// authenticationToken = authTokenRepository.findByAuthId(authId);
		return authTokenRepository.findByAuthId(authId);
	}

	@Override
	public AuthenticationToken getByUser(Users user) {
		return authTokenRepository.findByUser(user);

	}

	@Override
	public AuthenticationToken getByToken(String token) {
		return authTokenRepository.findByToken(token);
	}

	@Override
	public boolean isValidToken(String reqToken) {
		AuthenticationToken dbToken = getByToken(reqToken);

		if (dbToken == null) {
			return false;
		} else {
			if (dbToken.getExpiryDateTime().after(new Date()) && dbToken.getStatus().equals(StatusCode.ACTIVE)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public AuthenticationToken geneateAuthToken(long userId) {
		AuthenticationToken authenticationToken = new AuthenticationToken();
		List<AuthenticationToken> authList = new ArrayList<AuthenticationToken>();
		authList = getByUserAndStatusAndExpiryDateTimeBefore(userService.getUser(userId), StatusCode.ACTIVE,
				new Date());
		if (authList == null && authList.isEmpty()) {
			authenticationToken.setToken(generateToken());
			authenticationToken.setStatus(StatusCode.ACTIVE);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.HOUR_OF_DAY, 3);
			authenticationToken.setUser(userService.getUser(userId));
			authenticationToken.setExpiryDateTime(calendar.getTime());
			return authTokenRepository.save(authenticationToken);
		} else {
			return authList.get(0);
		}

	}

	public String generateToken() {
		AuthenticationToken dbAuthToken = new AuthenticationToken();
		Random random = new Random();
		char[] tokenArray = "abcdefghijklmnopqrstuvwxyz0123456789!@#$%".toCharArray();
		String token = "";
		for (int i = 0; i < tokenArray.length; i++) {
			token = token + tokenArray[random.nextInt(tokenArray.length - 1)];
		}

		dbAuthToken = authTokenRepository.findByToken(token);
		if (dbAuthToken != null) {
			generateToken();
		}

		return token;
	}

	@Override
	public List<AuthenticationToken> getByUserAndStatus(Users user, StatusCode code) {
		return authTokenRepository.findByUserAndStatus(user, code);
	}

	@Override
	public List<AuthenticationToken> getByUserAndStatusAndExpiryDateTimeBefore(Users user, StatusCode code,
			Date expiryDate) {
		return authTokenRepository.findByUserAndStatusAndExpiryDateTimeBefore(user, code, expiryDate);
	}
}
