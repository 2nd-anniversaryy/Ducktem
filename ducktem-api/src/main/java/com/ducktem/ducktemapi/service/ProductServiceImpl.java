package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.SalesStatus;
import com.ducktem.ducktemapi.exception.ProductException;
import com.ducktem.ducktemapi.repository.MemberRepository;
import com.ducktem.ducktemapi.repository.ProductRepository;
import com.ducktem.ducktemapi.util.TimeFormatter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	private final MemberRepository memberRepository;

	@Override
	@Transactional
	public ProductDetailResponse get(Long id) {
		Product product = productRepository.findById(id).orElseThrow(()->new ProductException("상품이 존재하지 않습니다."));

		return ProductDetailResponse.from(product);
	}


	// 상품 레포지토리에서 paging 이후 productPreview로 바꿔서 반환.
	@Override
	@Transactional
	public List<ProductPreviewResponse> getList(Pageable pageable) {

		return productRepository.findAll(pageable).map(ProductPreviewResponse::from).toList();
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
