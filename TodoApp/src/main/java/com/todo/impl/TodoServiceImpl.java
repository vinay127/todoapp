package com.todo.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo.exception.NotificationType;
import com.todo.exception.TodoException;
import com.todo.exception.TransactionalInfo;
import com.todo.model.Todo;
import com.todo.model.Users;
import com.todo.repository.ToDoRepository;
import com.todo.repository.UserRepository;
import com.todo.service.TodoService;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

	@Autowired
	ToDoRepository todoRepo;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TransactionalInfo transactionalInfo;

	// before current date");
	@Override
	public void saveTodo(Todo todo) {
		Users user = todo.getUser();
		// try {
		// validateTodo(todo);
		// } catch (TodoException e) {
		//// System.out.println(e.getMessage());
		// }

		validateTodo(todo);
		user = userRepository.findByUserId(user.getUserId());
		todo.setUser(user);
		todoRepo.save(todo);
	}

	private void validateTodo(Todo todo) throws TodoException {
		System.out.println(todo.getTitle() == null);
		if (todo.getTitle() == null) {
			transactionalInfo.generateException("Todo Title can not be null", 500, NotificationType.ERROR);
			// } else if (todo.getReminderDateTime().before(new Date())) {
			// transactionalInfo.generateException("Todo Title can not be null", 500,
			// NotificationType.ERROR);
			// }
		}
	}

}
