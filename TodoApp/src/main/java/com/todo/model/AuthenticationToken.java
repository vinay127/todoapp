package com.todo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.todo.codetype.StatusCode;

@Entity(name = "authenticationtoken")
public class AuthenticationToken {

	@Id
	@GeneratedValue
	private long authId;

	@GeneratedValue
	@Column(name = "token")
	private String token;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "userid", name = "userid")
	private Users user;

	@Column(name = "status")
	private StatusCode status;

	@Column(name = "expirydatetime")
	private Date expiryDateTime;

	public long getAuthId() {
		return authId;
	}

	public void setAuthId(long authId) {
		this.authId = authId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public StatusCode getStatus() {
		return status;
	}

	public void setStatus(StatusCode status) {
		this.status = status;
	}

	public Date getExpiryDateTime() {
		return expiryDateTime;
	}

	public void setExpiryDateTime(Date expiryDateTime) {
		this.expiryDateTime = expiryDateTime;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
