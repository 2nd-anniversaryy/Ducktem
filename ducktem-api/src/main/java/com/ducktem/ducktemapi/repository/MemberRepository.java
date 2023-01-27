package com.ducktem.ducktemapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducktem.ducktemapi.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByUserId(String userId);

	Optional<Member> findByNickName(String nickName);
}
