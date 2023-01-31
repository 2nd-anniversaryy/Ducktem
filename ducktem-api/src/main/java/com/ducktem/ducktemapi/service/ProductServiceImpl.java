package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ducktem.ducktemapi.dto.request.ProductRegisterRequest;
import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.SalesStatus;
import com.ducktem.ducktemapi.exception.MemberException;
import com.ducktem.ducktemapi.exception.ProductException;
import com.ducktem.ducktemapi.repository.CategoryRepository;
import com.ducktem.ducktemapi.repository.MemberRepository;
import com.ducktem.ducktemapi.repository.ProductRepository;
import com.ducktem.ducktemapi.util.TimeFormatter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	private final MemberRepository memberRepository;
	private final CategoryRepository categoryRepository;


	@Override
	@Transactional
	public ProductDetailResponse get(Long id) {
		Product product = productRepository.findById(id).orElseThrow(()->new ProductException("상품이 존재하지 않습니다."));

		return ProductDetailResponse.from(product);
	}

	@Override
	@Transactional
	public List<ProductPreviewResponse> getList(Pageable pageable) {

		return productRepository.findAll(pageable)
				.map(ProductPreviewResponse::from)
				.toList();
	}

	@Override
	@Transactional
	public Product add(ProductRegisterRequest request, String regMemberId) {
		Member member = memberRepository.findByUserId(regMemberId).orElseThrow(() -> new MemberException("몰라"));
		Category category = categoryRepository.findById(request.getCategory())
			.orElseThrow(() -> new ProductException("없는 카테고리입니다."));
		return productRepository.save(Product
			.builder()
			.name(request.getName())
			.price(request.getPrice())
			.description(request.getDescription())
			.condition(request.getCondition())
			.deliveryType(request.getDeliveryType())
			.regDate(TimeFormatter.NOW())
			.updateDate(TimeFormatter.NOW())
			.salesStatus(SalesStatus.ON)
			.member(member)
			.category(category)
			.build());
	}

	@Override
	@Transactional
	public Product update(ProductRegisterRequest request, Long id) {
		Product product = productRepository.findById(id)
			.orElseThrow(() -> new ProductException("잘못된 접근입니다."));
			Category category = categoryRepository.findById(request.getCategory())
			.orElseThrow(() -> new ProductException("없는 카테고리입니다."));

		Optional.ofNullable(request.getName())
			.ifPresent(product::setName);
		Optional.ofNullable(request.getPrice())
			.ifPresent(product::setPrice);
		Optional.ofNullable(category)
			.ifPresent(product::setCategory);
		Optional.ofNullable(request.getCondition())
			.ifPresent(product::setCondition);
		Optional.ofNullable(request.getDeliveryType())
			.ifPresent(product::setDeliveryType);
		Optional.ofNullable(request.getDescription())
			.ifPresent(product::setDescription);
		product.setUpdateDate(TimeFormatter.NOW());

		return product;

	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}