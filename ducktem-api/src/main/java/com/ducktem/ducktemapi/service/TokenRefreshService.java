package com.ducktem.ducktemapi.service;

public interface TokenRefreshService {
	String refreshAccessToken(String token);
}
