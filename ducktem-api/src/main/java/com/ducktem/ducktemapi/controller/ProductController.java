package com.ducktem.ducktemapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.service.ProductService;
import com.ducktem.ducktemapi.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

	private final ProductService productservice;
	private final SearchService searchService;



	@GetMapping
	@Transactional
	public Map<String,Object> getList(
		@PageableDefault(size = 20) Pageable pageable,
		@RequestParam(name = "q", defaultValue = "") String query,
		@RequestParam(name = "c", defaultValue = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15")Integer[] category,
		@RequestParam(name="f", defaultValue = "최신순") String filter
	){
		Map<String ,Object> searchResultByCategory =new HashMap<>();

		Long countResult = searchService.getCountByQuery(query,category);
		searchResultByCategory.put("countResult",countResult);

		switch (filter){
			case "최신순":
				List<ProductPreviewResponse> productResult= searchService.getListByCategoryAndSearch(pageable, query, category);
				searchResultByCategory.put("productResult",productResult);
				break;
			case "높은가격순":
				List<ProductPreviewResponse> productResultByPriceDesc= searchService.getListByCategoryAndSearchOrderByPriceDesc(pageable, query, category);
				searchResultByCategory.put("productResult",productResultByPriceDesc);
				break;
			case "낮은가격순":
				List<ProductPreviewResponse> productResultByPrice= searchService.getListByCategoryAndSearchOrderByPrice(pageable, query, category);
				searchResultByCategory.put("productResult",productResultByPrice);
				break;
			case "인기상품순":
				List<ProductPreviewResponse> productResultByHit= searchService.getListByCategoryAndSearchOrderByHit(pageable, query, category);
				searchResultByCategory.put("productResult",productResultByHit);
				break;
		}

		return searchResultByCategory;
	}




	// 상품 상세 페이지 요청 /products/2
	@GetMapping("{id}")
	public ProductDetailResponse get(@PathVariable Long id) {
		return productservice.get(id);
	}




	//상품 추가
	@PostMapping
	public Product add(@RequestBody Product product, Authentication authentication) {
		String regMemberId = authentication.getName();
		return productservice.add(product, regMemberId);
	}


}
