package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.SalesStatus;
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

	// 카테고리와 검색어로 검색한 결과를 Count. Long 타입으로 반환.
	@Override
	public Long getCountByQuery(String query, Integer[] categoryId) {
		List<Category> category = (List<Category>)categoryRepository.findByIdIn(categoryId);
		String newQuery = "%"+query+"%";

		return productRepository.countProductByNameLikeQuery(newQuery,category);
	}
	// 카테고리로 검색한 상품 결과를 상품 레포지토리에서 paging 이후 productPreview로 바꿔서 반환.
	@Override
	public List<ProductPreviewResponse> getListByCategory(Pageable pageable, Integer[] categoryId) {


		 List<Category> category = (List<Category>)categoryRepository.findByIdIn(categoryId);

		return productRepository.findByCategoryInOrderByIdDesc(pageable, category)
								.map(ProductPreviewResponse::from)
								.toList();
	}
	// 카테고리와 검색어로 검색한 상품 결과를 상품 레포지토리에서 paging 이후 productPreview로 바꿔서 반환.
	@Override
	public List<ProductPreviewResponse> getListByCategoryAndSearch(
					Pageable pageable, String query, Integer[] categoryId) {

		List<Category> category = (List<Category>)categoryRepository.findByIdIn(categoryId);
		String newQuery = "%"+query+"%";
		return productRepository.findByNameQueryAndCategoryInOrderByIdDesc(pageable,newQuery, category)
								.map(ProductPreviewResponse::from)
								.toList();
	}

	// 상품 레포지토리에서 paging 이후 productPreview로 바꿔서 반환.
	@Override
	@Transactional
	public List<ProductPreviewResponse> getList(Pageable pageable) {

		return productRepository.findAll(pageable)
			.map(ProductPreviewResponse::from)
			.toList();
	}

	@Override
	public List<ProductPreviewResponse> getListBySearch(Pageable pageable, String query) {

		String newQuery = "%"+query+"%";

		return productRepository.findByNameQueryOrderByIdDesc(pageable, newQuery)
			.map(ProductPreviewResponse::from)
			.toList();
	}

	@Override
	@Transactional
	public Product add(Product product, String regMemberId) {
		Optional<Member> member = memberRepository.findByUserId(regMemberId);
		System.out.println("product = " + product);
		if (member.isPresent()) {
			Member regMember = member.get();
			product.setMember(regMember);
			product.setRegDate(TimeFormatter.NOW());
			product.setUpdateDate(TimeFormatter.NOW());
			product.setSalesStatus(SalesStatus.ON);
			product = productRepository.save(product);
		}
		return product;
	}

}
