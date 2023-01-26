package com.ducktem.ducktemapi.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.ducktemapi.dto.response.ProductPreview;
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
	public List<ProductPreview> getList(@PageableDefault(size = 3) Pageable pageable) {
		return productservice.getList(pageable);
	}

	// /products/2
	@GetMapping(path = "{id}", produces = {
		MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE
	})
	public Product get(@PathVariable Long id) {

		Product product = productservice.get(id);

		return product;
	}

	@PostMapping
	public Product add(@RequestBody Product product, Authentication authentication) {
		String regMemberId = authentication.getName();
		return productservice.add(product,regMemberId);
	}
}
