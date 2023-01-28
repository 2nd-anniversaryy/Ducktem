package com.ducktem.ducktemapi.service;


import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
	ProductDetailResponse get(Long id);

	Product add(Product product, String regMemberId);

	List<ProductPreviewResponse> getList(Pageable pageable);

	List<ProductPreviewResponse> getListByQuery(Pageable pageable, String query);

	List<ProductPreviewResponse> getListByCategory(Pageable pageable, Integer[] category);


}
