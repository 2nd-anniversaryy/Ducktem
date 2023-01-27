package com.ducktem.ducktemapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TokenResponse {
	private String access;
	private String refresh;

	public static TokenResponse from(String accessJwt, String refreshJwt) {
		return TokenResponse.builder().access(accessJwt).refresh(refreshJwt).build();

	}
}
