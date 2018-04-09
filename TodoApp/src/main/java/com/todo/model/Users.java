package com.todo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.todo.codetype.StatusCode;

@Entity(name = "users")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Users {

	@Id
	@GeneratedValue
	@Column(name = "userid")
	private long userId;

	@Column(name = "username")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(updatable = false, name = "createddatetime")
	private Date createdDateTime;

	@Column(name = "status")
	private StatusCode status;

	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	List<Todo> todos;

	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Address> address;

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public StatusCode getStatus() {
		return status;
	}

	public void setStatus(StatusCode status) {
		this.status = status;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

}
