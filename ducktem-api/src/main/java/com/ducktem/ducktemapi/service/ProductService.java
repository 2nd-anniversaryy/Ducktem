package com.ducktem.ducktemapi.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ducktem.ducktemapi.dto.response.ProductDetailResponse;
import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.Product;

public interface ProductService {
	ProductDetailResponse get(Long id);

	Product add(Product product, String regMemberId);

	List<ProductPreviewResponse> getList(Pageable pageable);

	List<ProductPreviewResponse> getListBySearch(Pageable pageable, String query);

	Long getCountByQuery(String query, Integer[] category);

	List<ProductPreviewResponse> getListByCategory(Pageable pageable, Integer[] category);

	List<ProductPreviewResponse> getListByCategoryAndSearch(Pageable pageable,String query,Integer[] category);
	//높은가격순
	List<ProductPreviewResponse> getListByCategoryAndSearchOrderByPriceDesc(Pageable pageable,String query,Integer[] category);
	//낮은가격순
	List<ProductPreviewResponse> getListByCategoryAndSearchOrderByPrice(Pageable pageable,String query,Integer[] category);


}
