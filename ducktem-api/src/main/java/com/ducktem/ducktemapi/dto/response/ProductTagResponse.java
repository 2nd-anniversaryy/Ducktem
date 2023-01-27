package com.ducktem.ducktemapi.dto.response;

import java.util.List;

import com.ducktem.ducktemapi.entity.Tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductTagResponse {
	private String name;

	public static List<ProductTagResponse> from(List<Tag> tagList) {
		return tagList.stream().map(Tag::getName).map(ProductTagResponse::new).toList();
	}
}
