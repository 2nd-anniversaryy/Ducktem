package com.ducktem.ducktemapi.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.repository.CategoryRepository;
import com.ducktem.ducktemapi.repository.MemberRepository;
import com.ducktem.ducktemapi.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SearchServiceImpl implements SearchService{

	private final ProductRepository productRepository;
	private final MemberRepository memberRepository;
	private final CategoryRepository categoryRepository;


	// 카테고리와 검색어로 검색한 결과를 Count. Long 타입으로 반환.
	@Override
	public Long getCountByQuery(String query, Integer[] categoryId) {
		List<Category> category = (List<Category>)categoryRepository.findByIdIn(categoryId);
		String newQuery = "%"+query+"%";

		return productRepository.countProductByNameLikeQuery(newQuery,category);
	}

	// 카테고리와 검색어로 검색한 상품 결과를 상품 레포지토리에서 paging 이후 productPreview로 바꿔서 반환.
	// 최신순
	@Override
	public List<ProductPreviewResponse> getListByCategoryAndSearch(
		Pageable pageable, String query, Integer[] categoryId) {

		List<Category> category = (List<Category>)categoryRepository.findByIdIn(categoryId);
		String newQuery = "%"+query+"%";
		return productRepository.findByNameQueryAndCategoryInOrderByIdDesc(pageable,newQuery, category)
			.map(ProductPreviewResponse::from)
			.toList();
	}


	//높은가격순
	@Override
	public List<ProductPreviewResponse> getListByCategoryAndSearchOrderByPriceDesc(Pageable pageable, String query,
		Integer[] categoryId) {
		List<Category> category = (List<Category>)categoryRepository.findByIdIn(categoryId);
		String newQuery = "%"+query+"%";
		return productRepository.findByNameQueryAndCategoryInOrderByPriceDesc(pageable,newQuery, category)
			.map(ProductPreviewResponse::from)
			.toList();
	}
	//낮은가격순
	@Override
	public List<ProductPreviewResponse> getListByCategoryAndSearchOrderByPrice(Pageable pageable, String query,
		Integer[] categoryId) {
		List<Category> category = (List<Category>)categoryRepository.findByIdIn(categoryId);
		String newQuery = "%"+query+"%";
		return productRepository.findByNameQueryAndCategoryInOrderByPrice(pageable,newQuery, category)
			.map(ProductPreviewResponse::from)
			.toList();
	}
	//조회수순
	@Override
	public List<ProductPreviewResponse> getListByCategoryAndSearchOrderByHit(Pageable pageable, String query,
		Integer[] categoryId) {
		List<Category> category = (List<Category>)categoryRepository.findByIdIn(categoryId);
		String newQuery = "%"+query+"%";
		return productRepository.findByNameQueryAndCategoryInOrderByHit(pageable,newQuery, category)
			.map(ProductPreviewResponse::from)
			.toList();
	}

}
