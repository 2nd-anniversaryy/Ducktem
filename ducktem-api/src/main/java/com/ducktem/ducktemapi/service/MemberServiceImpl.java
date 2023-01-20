package com.ducktem.ducktemapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.MemberDto;
import com.ducktem.ducktemapi.jwt.JwtProvider;
import com.ducktem.ducktemapi.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

	private final JwtProvider jwtProvider;

	@Override
	public Member get(String userId) {
		return memberRepository.findByUserId(userId);
	}

	@Override
	public Member join(Member member) {

		return memberRepository.save(member);
	}

	@Override
	public String login(MemberDto memberDto) {
		String userId = memberDto.getUserId();
		return jwtProvider.createJwt(userId);
	}

	@Override
	public List<Member> getList() {
		return null;
	}

}
