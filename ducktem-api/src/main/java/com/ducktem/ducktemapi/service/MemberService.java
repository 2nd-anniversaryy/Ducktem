package com.ducktem.ducktemapi.service;

import java.util.List;

import com.ducktem.ducktemapi.dto.MemberDto;
import com.ducktem.ducktemapi.entity.Member;

public interface MemberService {
	Member get(String userId);

	Member join(Member member);

	String login(MemberDto memberDto);

	List<Member> getList();

}
