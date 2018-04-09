package com.todo.exception;

import org.springframework.stereotype.Component;

@Component
public class TransactionalInfo {

	public void generateException(String message, int statusCode, NotificationType notificationType) {
		throw new TodoException(message, statusCode, notificationType);
	}
}
