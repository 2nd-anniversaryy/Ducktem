package com.ducktem.ducktemapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ducktem.ducktemapi.dto.request.LoginRequest;
import com.ducktem.ducktemapi.dto.request.MemberInfoRequest;
import com.ducktem.ducktemapi.dto.response.MemberInfoResponse;
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

	@GetMapping("me")
	public ResponseEntity<MemberInfoResponse> myInfo(Authentication authentication) {

		return new ResponseEntity<>(memberService.getInfo(authentication.getName()), HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<MemberInfoResponse> updateInfo(MemberInfoRequest memberInfoRequest, Authentication authentication, @RequestPart MultipartFile file) {
		return new ResponseEntity<>(memberService.updateInfo(authentication.getName(),memberInfoRequest,file), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<String> getUserId(@RequestBody LoginRequest loginRequest) {
		return new ResponseEntity<>(memberService.get(loginRequest).getUserId(), HttpStatus.OK);

	}
	@PostMapping("/members/test")
	public String test() {
		return "권한 성공";
	}

}
