package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ducktem.ducktemapi.dto.MemberDto;
import com.ducktem.ducktemapi.dto.response.LoginResponse;
import com.ducktem.ducktemapi.dto.response.TokenResponse;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.MemberStatus;
import com.ducktem.ducktemapi.entity.RefreshToken;
import com.ducktem.ducktemapi.exception.MemberException;
import com.ducktem.ducktemapi.jwt.JwtProvider;
import com.ducktem.ducktemapi.repository.MemberRepository;
import com.ducktem.ducktemapi.repository.RefreshTokenRepository;
import com.ducktem.ducktemapi.util.TimeFormatter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	private final MemberRepository memberRepository;

	private final PasswordEncoder passwordEncoder;
	private final JwtProvider jwtProvider;
	private final RefreshTokenRepository refreshTokenRepository;

	@Override
	public Member get(String userId) {

		Optional<Member> member = memberRepository.findByUserId(userId);
		if (member.isEmpty()) {
			throw new MemberException("존재하지 않는 회원입니다.");
		}

		return member.get();
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

	@Override
	@Transactional
	public LoginResponse login(MemberDto memberDto) {
		Member member = valid(memberDto);
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
			.userId(member.getNickName())
			.tokenResponse(token).build();
	}

	@Override
	public List<Member> getList() {
		return null;
	}

	// 아이디,패스워드 별로 예외를 나눔.
	private Member valid(MemberDto memberDto) {
		Optional<Member> member = memberRepository.findByUserId(memberDto.getUserId());
		if (member.isPresent()) {
			if (!passwordEncoder.matches(memberDto.getPwd(), member.get().getPwd()))
				throw new MemberException("비밀번호가 다릅니다.");
		} else {
			throw new MemberException("회원아이디가 존재하지 않습니다.");
		}
		return member.get();
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
}
