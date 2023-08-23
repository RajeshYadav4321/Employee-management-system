package com.employee.controller.excption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException ex){
	String message = ex.getMessage();
	return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
}
}
