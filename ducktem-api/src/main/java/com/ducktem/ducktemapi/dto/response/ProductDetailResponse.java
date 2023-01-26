package com.ducktem.ducktemapi.dto.response;

import java.util.List;

import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.SalesStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailResponse {
	private String name;
	private String price;
	private String description;
	private String condition;
	private int hit;
	private String updateDate;
	private List<ProductImageResponse> productImageList;
	private String regMemberId;
	private SalesStatus salesStatus;

	public static ProductDetailResponse from(Product product) {
		return ProductDetailResponse.builder()
			.name(product.getName())
			.price(product.getPrice())
			.description(product.getDescription())
			.condition(product.getCondition())
			.hit(product.getHit())
			.updateDate(product.getUpdateDate())
			.productImageList(ProductImageResponse.from(product.getProductImageList()))
			.regMemberId(product.getMember().getUserId())
			.salesStatus(product.getSalesStatus())
			.build();
	}
}
