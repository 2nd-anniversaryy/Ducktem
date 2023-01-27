package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.entity.ProductImage;
import com.ducktem.ducktemapi.repository.ProductImageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductImageServiceImpl implements ProductImageService{

	private final ProductImageRepository imageRepository;

	@Override
	public List<ProductImage> getThumbNailList() {
		Optional<List<ProductImage>> thumbNails = imageRepository.findByThumbNail((byte)1);
		List<ProductImage> thumbNailList = null;
		if(thumbNails.isPresent())
			thumbNailList = thumbNails.get();


		return thumbNailList;
	}

	@Override
	public List<ProductImage> getImages() {
		return null;
	}
}
