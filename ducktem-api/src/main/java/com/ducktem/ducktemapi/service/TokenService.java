package com.ducktem.ducktemapi.service;

import com.ducktem.ducktemapi.dto.response.LoginResponse;
import com.ducktem.ducktemapi.entity.Member;

public interface TokenService {
	String refreshAccessToken(String token);

	LoginResponse login(Member member);
}
