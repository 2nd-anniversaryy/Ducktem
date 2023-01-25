package com.ducktem.ducktemapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducktem.ducktemapi.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}