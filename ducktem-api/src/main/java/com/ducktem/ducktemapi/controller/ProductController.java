package com.ducktem.ducktemapi.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.service.ProductService;
import com.ducktem.ducktemapi.service.TagService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

	private final ProductService productservice;
	private final TagService tagService;

	// /products?p=1&s=15
	@GetMapping
	public List<ProductPreviewResponse> getList(@PageableDefault(size = 3) Pageable pageable) {
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
		return productservice.add(product,regMemberId);
	}

	@PostMapping("test")
	public Product addTest(@RequestBody Product product, Authentication authentication) {
		String regMemberId = authentication.getName();
		Product newOne = productservice.add(product,regMemberId);
		Long productId = newOne.getId();
		String tag = newOne.getTag();
		tagService.add(tag, productId, (byte) 0);
		
		return productservice.add(product,regMemberId);
	}	
}
