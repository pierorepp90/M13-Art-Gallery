package com.bcnit13.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorsMessage {
	
	@JsonProperty("message")
	private String message;
	
	public ErrorsMessage() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public static ErrorsMessage fromStringToError(String message) {
		ErrorsMessage error = new ErrorsMessage();
		error.setMessage(message);
		return error;
	}
}
