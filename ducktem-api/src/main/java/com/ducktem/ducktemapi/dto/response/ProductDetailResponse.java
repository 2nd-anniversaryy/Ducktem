package com.ducktem.ducktemapi.dto.response;

import java.util.List;
import java.util.Objects;

import com.ducktem.ducktemapi.entity.Product;
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
public class ProductDetailResponse {
	private Long id;
	private String name;
	private Long price;
	private String description;
	private String condition;
	private int hit;
	private String updateDate;
	private List<ProductImageResponse> imgNames;
	private List<ProductTagResponse> tags;
	private String subCategory;
	private String superCategory;
	private MemberInfoResponse regMemberInfo;
	@Setter
	private List<ProductPreviewResponse> otherProducts;
	private int otherProductsSize;
	private SalesStatus salesStatus;
	@Setter
	private int wishStatus;
	private String deliveryType;

	public static ProductDetailResponse from(Product product) {
		return ProductDetailResponse.builder()
			.id(product.getId())
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
			.regMemberInfo(MemberInfoResponse.from(product.getMember()))
			.otherProducts(ProductPreviewResponse.fromList(product.getMember()
				.getProductList()
				.stream()
				.filter(memberProduct -> !Objects.equals(memberProduct.getId(), product.getId())).toList()))
			.otherProductsSize(product.getMember().getProductList().size())
			.salesStatus(product.getSalesStatus())
			.deliveryType(product.getDeliveryType())
			.build();
	}
}
