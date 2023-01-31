package com.ducktem.ducktemapi.dto.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegisterRequest {
	private String name;
	private Long price;
	private String description;
	private String condition;
	private String deliveryType;
	private String[] tagNames;
	private MultipartFile[] files;
	private Integer category;

}
