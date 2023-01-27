package com.ducktem.ducktemapi.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Product;

public interface ProductService {
	ProductDetailResponse get(Long id);

	Product add(Product product, String regMemberId);

	List<ProductPreviewResponse> getList(Pageable pageable);
}
