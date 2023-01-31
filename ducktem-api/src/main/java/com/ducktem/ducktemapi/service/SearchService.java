package com.ducktem.ducktemapi.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;

public interface SearchService {

	Long getCountByQuery(String query, Integer[] category);
	//최신순
	List<ProductPreviewResponse> getListByCategoryAndSearch(Pageable pageable,String query,Integer[] category);
	//높은가격순
	List<ProductPreviewResponse> getListByCategoryAndSearchOrderByPriceDesc(Pageable pageable,String query,Integer[] category);
	//낮은가격순
	List<ProductPreviewResponse> getListByCategoryAndSearchOrderByPrice(Pageable pageable,String query,Integer[] category);
	//인기상품순
	List<ProductPreviewResponse> getListByCategoryAndSearchOrderByHit(Pageable pageable,String query,Integer[] category);

}
