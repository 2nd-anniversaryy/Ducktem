package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.SalesStatus;
import com.ducktem.ducktemapi.repository.MemberRepository;
import com.ducktem.ducktemapi.repository.ProductRepository;
import com.ducktem.ducktemapi.util.TimeFormatter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class ProductServiceImpl implements ProductService {
	@Autowired
	private final ProductRepository productRepository;
	@Autowired
	private final MemberRepository memberRepository;

	@Override
	public Product get(Long id) {

		Product product = null;

		Optional<Product> opt = productRepository.findById(id);
		if (opt.isPresent())
			product = opt.get();

		return product;
	}

	@Override
	public List<Product> getList() {

		List<Product> list = productRepository.findAll();

		return list;
	}

	@Override
	@Transactional
	public Product add(Product product, String regMemberId) {
		Optional<Member> member = memberRepository.findByUserId(regMemberId);

		Product newProduct = null;

		if(member.isPresent()) {
			Member regMember = member.get();
			product.setMember(regMember);
			product.setRegDate(TimeFormatter.NOW());
			product.setUpdateDate(TimeFormatter.NOW());
			product.setSalesStatus(SalesStatus.ON);
			newProduct = productRepository.save(product);
		}
		return newProduct;
	}

}
