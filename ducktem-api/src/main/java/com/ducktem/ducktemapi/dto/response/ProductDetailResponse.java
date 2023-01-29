package com.ducktem.ducktemapi.dto.response;

import java.util.List;

import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.SalesStatus;
import com.ducktem.ducktemapi.util.TimeFormatter;

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
	private List<ProductImageResponse> imgNames;
	private List<ProductTagResponse> tags;
	private String subCategory;
	private String superCategory;
	private String regMemberId;
	private SalesStatus salesStatus;

	public static ProductDetailResponse from(Product product) {
		return ProductDetailResponse.builder()
			.name(product.getName())
			.price(product.getPrice())
			.description(product.getDescription())
			.condition(product.getCondition())
			.hit(product.getHit())
			.updateDate(TimeFormatter.nTimeAgo(product.getUpdateDate()))
			.imgNames(ProductImageResponse.from(product.getProductImageList()))
			.superCategory(product.getCategory().getSuperCategory().getName())
			.subCategory(product.getCategory().getName())
			.tags(ProductTagResponse.from(product.getTag()))
			.regMemberId(product.getMember().getUserId())
			.salesStatus(product.getSalesStatus())
			.build();
	}
}
