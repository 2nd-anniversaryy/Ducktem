package com.ducktem.ducktemapi.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {
	private final String secretKey;
	private final Long expiredMs;

	public JwtProvider(@Value("${jwt.secret}") String secretKey, @Value("${jwt.expiredMs}") Long expiredMs){
		this.secretKey = secretKey;
		this.expiredMs = expiredMs;
	}

	public String createJwt(String userId) {
		Claims claims = Jwts.claims();
		claims.put("userId", userId);

		return Jwts.builder().setClaims(claims)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + expiredMs))
			.signWith(SignatureAlgorithm.HS256, secretKey)
			.compact();
	}

}
