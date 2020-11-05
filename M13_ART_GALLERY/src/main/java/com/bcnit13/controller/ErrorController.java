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
	public ResponseEntity<String> requestForbidden() {
		return new ResponseEntity<>("You shall not pass!",HttpStatus.FORBIDDEN);

	}

	@ExceptionHandler(ServletException.class)
	@ResponseBody
	public ResponseEntity<String> requestNotFound() {
		return new ResponseEntity<>("Please check the path,maybe you forgot a param.",HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class})
	@ResponseBody
	public ResponseEntity<String> invalidRequest() {
		return new ResponseEntity<>("Please check if the id is a number or the other paramethers are ok.",HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class, NoSuchElementException.class,  })
	@ResponseBody
	public ResponseEntity<String> cantFound() {
		return new ResponseEntity<>("Sorry,we can't find that store or picture",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	}
