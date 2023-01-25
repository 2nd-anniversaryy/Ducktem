package com.ducktem.ducktemapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.ducktemapi.dto.RefreshTokenDto;
import com.ducktem.ducktemapi.service.TokenRefreshService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TokenRefreshController {
	private final TokenRefreshService tokenRefreshService;

	@PostMapping("/token")
	public String refreshAccessToken(@RequestBody RefreshTokenDto token) {

		return tokenRefreshService.refreshAccessToken(token.getToken());
	}
}
