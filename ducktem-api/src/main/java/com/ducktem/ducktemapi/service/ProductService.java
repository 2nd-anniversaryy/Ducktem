package com.ducktem.ducktemapi.service;

import java.util.List;

import com.ducktem.ducktemapi.entity.Product;

public interface ProductService {
	Product get(Long id);

	Product add(Product product, String regMemberId);

	List<Product> getList();

}
