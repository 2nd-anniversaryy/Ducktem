package com.ducktem.ducktemapi.dto.response;

import java.util.List;

import com.ducktem.ducktemapi.entity.ProductImage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductImageResponse {
	private Long id;
	private String imgUrl;

	public static List<ProductImageResponse> from(List<ProductImage> productImageList) {
		return productImageList.stream().map(image -> new ProductImageResponse(image.getId(),image.getName())).toList();
	}
}
