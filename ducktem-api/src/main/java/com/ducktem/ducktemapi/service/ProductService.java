package com.ducktem.ducktemapi.service;

import com.ducktem.ducktemapi.dto.request.ProductRegisterRequest;
import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
	ProductDetailResponse get(Long id);
	List<ProductPreviewResponse> getList();

	Product add(ProductRegisterRequest request, String regMemberId);

	Product update(ProductRegisterRequest request, Long id);

  void delete(Long id);

  void updateStatus(Long id, String status);

	List<ProductPreviewResponse> productList(String userId);
}
