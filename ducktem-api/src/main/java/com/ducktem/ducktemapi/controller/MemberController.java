package com.ducktem.ducktemapi.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.ducktemapi.dto.MemberDto;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberController {
	private final MemberService memberService;

	@PostMapping("/members/join")
	public Member join(@RequestBody Member member) {

		return memberService.join(member);
	}

	@PostMapping("/login")
	public Map<String,String> login(@RequestBody MemberDto memberDto) {
		return memberService.login(memberDto);
	}

	@PostMapping("/members/test")
	public String test() {
		return "권한 성공";
	}

}
