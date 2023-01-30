package com.ducktem.ducktemapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.exception.MemberException;
import com.ducktem.ducktemapi.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {
	private final MemberRepository memberRepository;

	@Override
	public List<ProductPreviewResponse> productList(String userId) {
		Member member = memberRepository.findByUserId(userId).orElseThrow(() -> new MemberException("잘못된 접근입니다."));

		return member.getProductList().stream().map(ProductPreviewResponse::from).toList();

	}
}
