package com.ducktem.ducktemapi.service;

import com.ducktem.ducktemapi.dto.request.ProductRegisterRequest;
import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.entity.Product;

public interface ProductService {
	ProductDetailResponse get(Long id);

	Product add(ProductRegisterRequest request, String regMemberId);

}
