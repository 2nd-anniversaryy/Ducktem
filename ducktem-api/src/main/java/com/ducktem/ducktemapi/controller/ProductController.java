package com.ducktem.ducktemapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.ducktemapi.entity.Product;

import jakarta.validation.Valid;

@RestController
@RequestMapping("products")
public class ProductController {

	// /products?p=1&s=15
	@GetMapping
	public String getList(
		@RequestParam(name = "p", defaultValue = "1") int page,
		@RequestParam("s") int size) {

		return String.format("get Product List:page=%d, size%d", page, size);
	}

	// /products/2
	@GetMapping(path = "{id}", produces = {
		MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE
	})
	public ResponseEntity<Product> get(@PathVariable int id) {

		Product product = Product.builder().name("러브다이브 미공포").price("80000").build();

		return new ResponseEntity<Product>(HttpStatus.OK);
	}

	@PostMapping(consumes = {
		MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE
	})
	public Product create(@Valid @RequestBody Product product) {

		System.out.println(product);

		// db에 저장

		// 방금 저장한 데이터를 다시 가져와서

		return product;
	}

	@PutMapping
	public Product update(@RequestBody Product product) {

		// Product p = null;
		// p.getId();

		return product;
	}

	// @DeleteMapping("{id}")
	// public ResponseEntity<void> delete(@PathVariable int id) {
	//     return ResponseEntity.noContent().build();
	// }

	@GetMapping("hello")
	public String hello() {
		return "hello";
	}
}
