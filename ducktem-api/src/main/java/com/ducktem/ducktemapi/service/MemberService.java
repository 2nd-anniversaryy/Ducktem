package com.ducktem.ducktemapi.service;

import java.util.List;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.MemberDto;

public interface MemberService {
	Member get(String userId);

	Member join(Member member);

	String login(MemberDto memberDto);

	List<Member> getList();

}
