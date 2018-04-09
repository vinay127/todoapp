package com.todo.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TodoExceptionMapper implements ExceptionMapper<TodoException> {

	@Override
	public Response toResponse(TodoException exception) {

		// MediaType.APPLICATION_JSON
		return Response.status(exception.getErrorInfo().getErrorCode()).type(MediaType.APPLICATION_JSON)
				.entity(exception.getErrorInfo()).build();
	}
}
