package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ducktem.ducktemapi.dto.request.LoginRequest;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.MemberStatus;
import com.ducktem.ducktemapi.exception.MemberException;
import com.ducktem.ducktemapi.repository.MemberRepository;
import com.ducktem.ducktemapi.repository.RefreshTokenRepository;
import com.ducktem.ducktemapi.util.TimeFormatter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	private final RefreshTokenRepository refreshTokenRepository;

	@Override
	public Member get(LoginRequest loginRequest) {
		Member member = memberRepository.findByUserId(loginRequest.getUserId())
			.orElseThrow(() -> new MemberException("회원아이디가 존재하지 않습니다."));

		if (member.getStatus() == MemberStatus.DISABLE) {
			throw new MemberException("이미 탈퇴한 회원입니다.");
		}

		return Optional.of(member)
			.filter(current -> passwordEncoder.matches(loginRequest.getPwd(), current.getPwd()))
			.orElseThrow(() -> new MemberException("비밀번호가 다릅니다."));
	}

	@Transactional
	@Override
	public Member join(Member member) {
		duplicateCheck(member);
		member.setStatus(MemberStatus.ENABLE);
		member.setPwd(passwordEncoder.encode(member.getPwd()));
		member.setRegDate(TimeFormatter.NOW());
		return memberRepository.save(member);
	}

	@Transactional
	@Override
	public void withDraw(LoginRequest loginRequest) {

		Member member = get(loginRequest);
		refreshTokenRepository.findByMember(member).ifPresent(refreshToken -> refreshToken.setRefreshToken("N/A"));
		member.setStatus(MemberStatus.DISABLE);
	}

	@Override
	public List<Member> getList() {
		return null;
	}



	// 회원가입시 id,nickname을 확인 한 후 기존 아이디가 존재한다면 예외를 발생시킴
	@Transactional
	public void duplicateCheck(Member member) {
		memberRepository.findByUserId(member.getUserId()).ifPresent(m -> {
			throw new MemberException("아이디가 중복되었습니다.");
		});
		memberRepository.findByNickName(member.getNickName()).ifPresent(m -> {
			throw new MemberException("아이디가 중복되었습니다.");
		});
	}
	// 아이디,패스워드 별로 예외를 나눔.

}
