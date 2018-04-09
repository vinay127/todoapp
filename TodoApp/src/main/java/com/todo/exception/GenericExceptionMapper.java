package com.todo.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

	ErrorResponse errorResponse;

	@Override
	public Response toResponse(Exception exception) {
		errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(500);
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.setNotificationType(NotificationType.ERROR);
		return Response.status(errorResponse.getErrorCode()).type(MediaType.APPLICATION_JSON).entity(errorResponse)
				.build();
	}

}
