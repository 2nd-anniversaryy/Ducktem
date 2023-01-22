package com.ducktem.ducktemapi.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {
	private final ProductService productService;

	@PostMapping
	public Product add(@RequestBody Product product, Authentication authentication) {
		String regMemberId = authentication.getName();
		return productService.add(product,regMemberId);
	}
}
