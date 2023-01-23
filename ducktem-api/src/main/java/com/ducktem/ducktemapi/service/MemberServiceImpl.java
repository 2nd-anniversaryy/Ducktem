package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.dto.MemberDto;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.exception.MemberException;
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

		Optional<Member> member = memberRepository.findByUserId(userId);
		if (member.isEmpty()) {
			throw new MemberException("존재하지 않는 회원입니다.");
		}

		return member.get();
	}

	@Override
	public Member join(Member member) {
		duplicateCheck(member);
		return memberRepository.save(member);
	}

	// 회원가입시 id,nickname을 확인 한 후 기존 아이디가 존재한다면 예외를 발생시킴
	public void duplicateCheck(Member member) {
		Optional<Member> userId = memberRepository.findByUserId(member.getUserId());
		Optional<Member> nickName = memberRepository.findByNickName(member.getNickName());

		if (userId.isPresent()) {
			throw new MemberException("아이디가 중복되었습니다.");
		} else if (nickName.isPresent()) {
			throw new MemberException("닉네임이 중복되었습니다.");
		}
	}

	@Override
	public String login(MemberDto memberDto) {
		String userId = null;

		if (isValid(memberDto)) {
			userId = memberDto.getUserId();
			return jwtProvider.createJwt(userId);
		}

		return "회원이 아닙니다.";
	}

	@Override
	public List<Member> getList() {
		return null;
	}

	private boolean isValid(MemberDto memberDto) {
		Optional<Member> member = memberRepository.findByUserIdAndPwd(memberDto.getUserId(), memberDto.getPwd());
		return member.isPresent();
	}
}
