package com.bcnit13.controller;

import java.security.AccessControlException;
import java.util.NoSuchElementException;
import javax.servlet.ServletException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ErrorController extends DefaultResponseErrorHandler {

	@ExceptionHandler(AccessControlException.class)
	@ResponseBody
	public ResponseEntity<ErrorsMessage> requestForbidden() {
		return new ResponseEntity<>(ErrorsMessage.fromStringToError("You shall not pass!"), HttpStatus.FORBIDDEN);

	}

	@ExceptionHandler({ServletException.class, NoSuchElementException.class })
	@ResponseBody
	public ResponseEntity<ErrorsMessage> requestNotFound() {
		return new ResponseEntity<>(ErrorsMessage.fromStringToError("Please check the path,maybe you forgot a param."),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class })
	@ResponseBody
	public ResponseEntity<ErrorsMessage> invalidRequest() {
		return new ResponseEntity<>(
				ErrorsMessage.fromStringToError("Please check if the id is a number or the other paramethers are ok."),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	@ResponseBody
	public ResponseEntity<ErrorsMessage> cantFound() {
		return new ResponseEntity<>(ErrorsMessage.fromStringToError("Sorry,we can't find that store or picture"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
