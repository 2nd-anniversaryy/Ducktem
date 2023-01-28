package com.ducktem.ducktemapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
	private String userId;
	private String nickName;
	private TokenResponse tokenResponse;
}
