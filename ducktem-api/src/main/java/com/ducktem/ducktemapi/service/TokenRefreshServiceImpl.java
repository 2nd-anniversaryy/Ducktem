package com.ducktem.ducktemapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.entity.RefreshToken;
import com.ducktem.ducktemapi.jwt.JwtProvider;
import com.ducktem.ducktemapi.repository.RefreshTokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenRefreshServiceImpl implements TokenRefreshService{
	private final JwtProvider jwtProvider;
	private final RefreshTokenRepository refreshTokenRepository;
	@Override
	public String refreshAccessToken(String token) {
		Optional<RefreshToken> refreshToken = refreshTokenRepository.findByRefreshToken(token);
		String refreshAccessToken = null;
		if(refreshToken.isPresent()) {
			jwtProvider.validOf(token);
			refreshAccessToken = jwtProvider.createAccessJwt(refreshToken.get().getMember().getUserId());
		}

		return refreshAccessToken;
	}
}
