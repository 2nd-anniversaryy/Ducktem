package com.ducktem.ducktemapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
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

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

	private final ProductService productservice;
	// /products?p=1&s=15
	@GetMapping
	public List<ProductPreviewResponse> getList(@PageableDefault(size = 20) Pageable pageable)
	{
		return productservice.getList(pageable);
	}

	// /products/2
	@GetMapping("{id}")
	public ProductDetailResponse get(@PathVariable Long id) {
		return productservice.get(id);
	}

	@PostMapping
	public Product add(@RequestBody Product product, Authentication authentication) {
		String regMemberId = authentication.getName();
		return productservice.add(product, regMemberId);
	}


	@GetMapping("/search")
	public Long getList(
											@PageableDefault(size = 20) Pageable pageable,
											@RequestParam(name = "q", defaultValue = "") String query
											){

		List<ProductPreviewResponse> ProductPreviewResponse = productservice.getListByQuery(pageable, query);
		Long searchCount = productservice.getCountByQuery(query);
		return searchCount;
	}


	@GetMapping("/category")
	public List<ProductPreviewResponse> getListByCategory(
												@PageableDefault(size = 200) Pageable pageable,
												@RequestParam(name = "c", defaultValue = "")Integer[] category
												){
		return productservice.getListByCategory(pageable, category);
	}


}
