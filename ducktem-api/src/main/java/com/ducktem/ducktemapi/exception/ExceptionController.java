package com.ducktem.ducktemapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(MemberException.class)
	public ResponseEntity<String> handleDuplicateIdException(MemberException e) {
		return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.CONFLICT);
	}
}
