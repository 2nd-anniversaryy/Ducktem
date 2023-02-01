package com.ducktem.ducktemapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.dto.response.WishListResponse;

@Service
public interface WishListService {
	List<WishListResponse> getList(String memberId);

	List<ProductPreviewResponse> confirmWishStatus(List<ProductPreviewResponse> tempProductPeviewResponseList,
		List<WishListResponse> userWishList);

	void add(Long productId, String memberId);

	void delete(Long productId, String memberId);

	List<ProductPreviewResponse> getMyWishList(String name);
}
