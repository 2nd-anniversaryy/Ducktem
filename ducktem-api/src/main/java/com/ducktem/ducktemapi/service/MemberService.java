package com.ducktem.ducktemapi.service;

import java.util.List;

import com.ducktem.ducktemapi.dto.request.LoginRequest;
import com.ducktem.ducktemapi.entity.Member;

public interface MemberService {
	Member get(LoginRequest loginRequest);

	Member join(Member member);

	void withDraw(LoginRequest loginRequest);

	List<Member> getList();

}
