package com.ducktem.ducktemapi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ducktem.ducktemapi.dto.request.LoginRequest;
import com.ducktem.ducktemapi.dto.request.MemberInfoRequest;
import com.ducktem.ducktemapi.dto.response.MemberInfoResponse;
import com.ducktem.ducktemapi.entity.Member;

public interface MemberService {
	Member get(LoginRequest loginRequest);

	Member join(Member member);

	void withDraw(LoginRequest loginRequest);

	List<Member> getList();

	MemberInfoResponse getInfo(String name);

	MemberInfoResponse updateInfo(String userId, MemberInfoRequest memberInfoRequest);
}
