package com.vidit.billing.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

	private LocalDateTime localDateTime;
	private int status;
	private String error;
	private String message;
	
	
	public ErrorResponse() {
		super();
	}


	public ErrorResponse(LocalDateTime localDateTime, int status, String error, String message) {
		super();
		this.localDateTime = localDateTime;
		this.status = status;
		this.error = error;
		this.message = message;
	}


	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}


	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "ErrorResponse [localDateTime=" + localDateTime + ", status=" + status + ", error=" + error
				+ ", message=" + message + "]";
	}
	
	
	
	
}
