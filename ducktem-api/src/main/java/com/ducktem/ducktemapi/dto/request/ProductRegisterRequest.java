package com.ducktem.ducktemapi.dto.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductRegisterRequest {
	private String name;
	private Long price;
	private String description;
	private String condition;
	private String deliveryType;
	private String[] tagNames;
	private int category;

}
