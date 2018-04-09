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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.todo.codetype.StatusCode;

@Entity(name = "todo")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Todo {

	@Id
	@GeneratedValue
	@Column(name = "todoid")
	private long toDoId;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "createddatetime")
	private Date createdDateTime;

	@Column(updatable = false, name = "reminderdatetime")
	private Date reminderDateTime;

	@Column(name = "status")
	private StatusCode status;

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName = "userid", name = "userid")
//	@JsonIgnore
	Users user;

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

	public long getToDoId() {
		return toDoId;
	}

	public void setToDoId(long toDoId) {
		this.toDoId = toDoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getReminderDateTime() {
		return reminderDateTime;
	}

	public void setReminderDateTime(Date reminderDateTime) {
		this.reminderDateTime = reminderDateTime;
	}

}
