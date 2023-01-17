package com.ducktem.ducktemapi.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberController {
	private final MemberService memberService;

	@PostMapping("/users/join")
	public Member join(@RequestBody Member member) {

		return memberService.join(member);
	}

}
