package com.ducktem.ducktemapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.ducktemapi.dto.request.LoginRequest;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("members")
public class MemberController {
	private final MemberService memberService;

	@PostMapping("/join")
	public Member join(@RequestBody Member member) {

		return memberService.join(member);
	}

	@DeleteMapping
	public ResponseEntity<Void> withDraw(@RequestBody LoginRequest loginRequest) {
		memberService.withDraw(loginRequest);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/members/test")
	public String test() {
		return "권한 성공";
	}

}
