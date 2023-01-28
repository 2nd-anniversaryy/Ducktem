package com.ducktem.ducktemapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.dto.response.LoginResponse;
import com.ducktem.ducktemapi.dto.response.TokenResponse;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.RefreshToken;
import com.ducktem.ducktemapi.jwt.JwtProvider;
import com.ducktem.ducktemapi.repository.RefreshTokenRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
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

	@Override
	@Transactional
	public LoginResponse login(Member member) {
		String refreshJwt = jwtProvider.createRefreshJwt();
		String accessJwt = jwtProvider.createAccessJwt(member.getUserId());
		Optional<RefreshToken> existingMember = refreshTokenRepository.findByMember(member);
		if (existingMember.isEmpty()) {
			refreshTokenRepository.save(RefreshToken.builder().refreshToken(refreshJwt).member(member).build());
		} else {
			existingMember.get().setRefreshToken(refreshJwt);
		}
		TokenResponse token = TokenResponse.from(accessJwt, refreshJwt);
		return LoginResponse
			.builder()
			.nickName(member.getNickName())
			.userId(member.getUserId())
			.tokenResponse(token).build();
	}

}
