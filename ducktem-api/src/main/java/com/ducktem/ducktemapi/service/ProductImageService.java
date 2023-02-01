package com.ducktem.ducktemapi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.ProductImage;

public interface ProductImageService {
	List<ProductImage> getThumbNailList();

	List<ProductImage> getImages();

	void add(MultipartFile[] files, Product product);

	void delete(Long id);

	void update(MultipartFile[] files, List<String> imgUrl ,Product product);
}
