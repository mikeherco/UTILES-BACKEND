package com.gobnl.main.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.*;

@ControllerAdvice
public class GobNLExceptionHandler  {
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ResponseEntity<Object> defaultHandlerException (MethodArgumentNotValidException exception){
		Map<String, String> errors = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error)-> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST );
	}
	
	
	@ExceptionHandler({NullPointerException.class})
	public ResponseEntity<Object> nullPointerException (NullPointerException exception){
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST );
	} 
}