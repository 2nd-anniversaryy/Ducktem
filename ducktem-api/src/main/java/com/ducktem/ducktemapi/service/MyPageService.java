package com.ducktem.ducktemapi.service;

import java.util.List;

import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;

public interface MyPageService {
	List<ProductPreviewResponse> productList(String userId);
}
