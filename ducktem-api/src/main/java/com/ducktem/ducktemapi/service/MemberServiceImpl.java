package com.ducktem.ducktemapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

	@Override
	public Member get(Integer id) {
		return null;
	}

	@Override
	public Member join(Member member) {

		return memberRepository.save(member);
	}

	@Override
	public List<Member> getList() {
		return null;
	}
}
