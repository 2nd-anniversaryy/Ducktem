package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.ProductImage;
import com.ducktem.ducktemapi.repository.ProductImageRepository;
import com.ducktem.ducktemapi.util.ImageUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductImageServiceImpl implements ProductImageService {

	private final ProductImageRepository imageRepository;

	@Override
	public List<ProductImage> getThumbNailList() {
		Optional<List<ProductImage>> thumbNails = imageRepository.findByThumbNail((byte)1);
		List<ProductImage> thumbNailList = null;
		if (thumbNails.isPresent())
			thumbNailList = thumbNails.get();

		return thumbNailList;
	}

	@Override
	public List<ProductImage> getImages() {
		return null;
	}

	@Override
	@Transactional
	public void add(MultipartFile[] files, Product product) {
		int i = 0;
		System.out.println(files.length);
		for (MultipartFile file : files) {
			String imgUrl = ImageUtil.save(file);
			if (imgUrl != null) {
				if (i == 0) {
					imageRepository.save(
						ProductImage.builder().name(imgUrl).product(product).thumbNail((byte)1).build());
				} else {
					imageRepository.save(
						ProductImage.builder().name(imgUrl).product(product).thumbNail((byte)0).build());
				}
				i++;
			}
		}
	}

	@Override
	public void delete(Long id) {
		imageRepository.deleteById(id);
	}
}
