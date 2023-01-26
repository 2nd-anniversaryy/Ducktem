package com.ducktem.ducktemapi.dto.response;

import com.ducktem.ducktemapi.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPreview {
	private Long productId;
	private String name;
	private String price;
	private String regDate;
	private String salesStatus;
	private String thumbNail;


	// 상품 정보에서 필요한 데이터만 취합하여 생성.
	@Builder
	public static ProductPreview from (Product product) {
		return ProductPreview.builder()
			.productId(product.getId())
			.name(product.getName())
			.price(product.getPrice())
			.regDate(product.getRegDate())
			.thumbNail(product
				.getProductImageList()
				.stream()
				.filter(image -> image.getThumbNail() == (byte)1)
				.findFirst()
				.get()
				.getName())
			.build();
	}

}
