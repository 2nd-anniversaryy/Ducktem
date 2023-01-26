package com.ducktem.ducktemapi.service;

import java.util.List;

import com.ducktem.ducktemapi.entity.ProductImage;

public interface ProductImageService {
	List<ProductImage> getThumbNailList();
	List<ProductImage> getImages();
}
