package com.todo.exception;

public class TodoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorResponse errorInfo;

	public TodoException(String errorMessage, int errorCode, NotificationType notificationType) {

		this.errorInfo = new ErrorResponse();
		this.errorInfo.setErrorMessage(errorMessage);
		this.errorInfo.setErrorCode(errorCode);
		this.errorInfo.setNotificationType(notificationType);
		// super(errorInfo);

	}

	public ErrorResponse getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorResponse errorInfo) {
		this.errorInfo = errorInfo;
	}

	// public TodoException(String message) {
	// super(message);
	// }

}
