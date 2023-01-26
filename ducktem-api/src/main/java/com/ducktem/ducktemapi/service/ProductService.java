package com.ducktem.ducktemapi.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ducktem.ducktemapi.dto.response.ProductPreview;
import com.ducktem.ducktemapi.entity.Product;

public interface ProductService {
	Product get(Long id);

	Product add(Product product, String regMemberId);

	List<ProductPreview> getList(Pageable pageable);
}
