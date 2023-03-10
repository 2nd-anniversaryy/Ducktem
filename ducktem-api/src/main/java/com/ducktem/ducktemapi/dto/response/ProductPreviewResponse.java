package com.ducktem.ducktemapi.dto.response;

import java.util.List;

import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.ProductImage;
import com.ducktem.ducktemapi.entity.SalesStatus;
import com.ducktem.ducktemapi.util.TimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPreviewResponse {
	private Long productId;
	private String name;
	private Long price;
	private String regDate;
	private SalesStatus salesStatus;
	private String thumbNail;
	@Setter
	private int wishStatus;

	// 상품 정보에서 필요한 데이터만 취합하여 생성.
	public static ProductPreviewResponse from(Product product) {
		return ProductPreviewResponse.builder()
			.productId(product.getId())
			.name(product.getName())
			.price(product.getPrice())
			.regDate(TimeFormatter.nTimeAgo(product.getRegDate()))
			.thumbNail(product
				.getProductImageList()
				.stream()
				.filter(image -> image.getThumbNail() == (byte)1)
				.findFirst()
				.orElseGet(ProductImage::new)
				// .orElseThrow(() -> new ProductException("데이터 오륲"))
				.getName())
			.salesStatus(product.getSalesStatus())
			.build();
	}

	public static List<ProductPreviewResponse> fromList(List<Product> products) {
		return products.stream().map(ProductPreviewResponse::from).toList();
	}

}
