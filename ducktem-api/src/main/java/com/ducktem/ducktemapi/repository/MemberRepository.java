package com.ducktem.ducktemapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducktem.ducktemapi.entity.Member;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
