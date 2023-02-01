package com.ducktem.ducktemapi.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ducktem.ducktemapi.dto.request.ProductRegisterRequest;
import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Product;

public interface ProductService {
	ProductDetailResponse get(Long id);

	List<ProductPreviewResponse> getList(Pageable pageable);

	Product add(ProductRegisterRequest request, String regMemberId);

	Product update(ProductRegisterRequest request, Long id);

	List<ProductPreviewResponse> productList(String userId);
}
