package com.ducktem.ducktemapi.service;

import java.util.List;

import com.ducktem.ducktemapi.entity.Member;

public interface MemberService {
	Member get(Integer id);

	Member join(Member member);

	List<Member> getList();

}
