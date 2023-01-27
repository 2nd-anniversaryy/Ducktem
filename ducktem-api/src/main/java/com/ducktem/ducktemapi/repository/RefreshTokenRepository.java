package com.ducktem.ducktemapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
	Optional<RefreshToken> findByRefreshToken(String token);

	Optional<RefreshToken> findByMember(Member member);

}