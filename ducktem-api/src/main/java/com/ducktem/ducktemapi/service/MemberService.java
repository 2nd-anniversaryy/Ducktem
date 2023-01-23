package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Map;

import com.ducktem.ducktemapi.dto.MemberDto;
import com.ducktem.ducktemapi.entity.Member;

public interface MemberService {
	Member get(String userId);

	Member join(Member member);

	Map<String,String> login(MemberDto memberDto);

	List<Member> getList();

}
