package com.todo.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.codetype.StatusCode;
import com.todo.model.Todo;
import com.todo.model.Users;

@Repository
public interface ToDoRepository extends JpaRepository<Todo, Serializable> {

	public Todo findByToDoId(long Id);

	public List<Todo> findByTitleAndDescription(String title, String description);

	public List<Todo> findByReminderDateTimeAfter(Date reminderDateTime);
	
    public List<Todo> findByUserAndStatus(Users user, StatusCode status);
    
    public List<Todo> findByReminderDateTimeAndUser(Date reminderDateTime, Users user);
    
    

}
