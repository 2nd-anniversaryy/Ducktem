package com.ducktem.ducktemapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.ducktemapi.dto.RefreshTokenDto;
import com.ducktem.ducktemapi.dto.request.LoginRequest;
import com.ducktem.ducktemapi.dto.response.LoginResponse;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.service.MemberService;
import com.ducktem.ducktemapi.service.TokenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TokenController {
	private final TokenService tokenService;
	private final MemberService memberService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
		Member member = memberService.get(loginRequest);
		return new ResponseEntity<>(tokenService.login(member), HttpStatus.OK);
	}

	@PostMapping("/token")
	public String refreshAccessToken(@RequestBody RefreshTokenDto token) {
		return tokenService.refreshAccessToken(token.getToken());
	}
}
