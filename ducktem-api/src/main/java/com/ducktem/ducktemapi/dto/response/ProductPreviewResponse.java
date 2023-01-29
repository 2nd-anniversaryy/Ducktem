package com.ducktem.ducktemapi.dto.response;

import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.ProductImage;
import com.ducktem.ducktemapi.entity.SalesStatus;
import com.ducktem.ducktemapi.exception.ProductException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPreviewResponse {
	private Long productId;
	private String name;
	private String price;
	private String regDate;
	private SalesStatus salesStatus;
	private String thumbNail;





	// 상품 정보에서 필요한 데이터만 취합하여 생성.
	@Builder
	public static ProductPreviewResponse from (Product product) {
		return ProductPreviewResponse.builder()

				.productId(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.regDate(product.getRegDate())
				.thumbNail(product
				.getProductImageList()
				.stream()
				.filter(image -> image.getThumbNail() == (byte)1)
				.findFirst()
				.orElseGet(()->new ProductImage())
				// .orElseThrow(() -> new ProductException("데이터 오륲"))
				.getName())
			.salesStatus(product.getSalesStatus())
			.build();
	}

}
