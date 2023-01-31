package com.ducktem.ducktemapi.service;

import com.ducktem.ducktemapi.entity.Product;

public interface ProductTagService {
	void add(String[] tagNames, Product product);
}
