package com.ducktem.ducktemapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(MemberException.class)
	public ResponseEntity<String> handleDuplicateIdException(MemberException e) {
		String msg = e.getLocalizedMessage();
		return switch (msg) {
			case "회원아이디가 존재하지 않습니다.", "비밀번호가 다릅니다." ->
				new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_ACCEPTABLE);
			default -> new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.CONFLICT);
		};

	}

	// 시큐리티 필터에서 예외처리가 되서 함수 실행이 안되는 상황. 임시로 예외필터를 만들어서 처리함. 예외 전체적인 수정이 필요함.
	@ExceptionHandler(JwtException.class)
	public ResponseEntity<String> handleJwtExpiredException(JwtException e) {
		return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.UNAUTHORIZED);
	}
}
