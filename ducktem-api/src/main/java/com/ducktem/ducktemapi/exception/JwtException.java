package com.ducktem.ducktemapi.exception;

public class JwtException extends RuntimeException{

	public JwtException(String message) {
		super(message);
	}
}
