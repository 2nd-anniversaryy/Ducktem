package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.repository.MemberRepository;
import com.ducktem.ducktemapi.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	private final MemberRepository memberRepository;

	@Override
	public Product get(Long id) {
		return null;
	}

	@Override
	@Transactional
	public Product add(Product product,String regMemberId) {
		Optional<Member> member = memberRepository.findByUserId(regMemberId);

		if(member.isPresent()) {
			Member regMember = member.get();
			product.setMember(regMember);
			product = productRepository.save(product);
		}
		return product;
	}

	@Override
	public List<Product> getList() {
		return null;
	}
}
