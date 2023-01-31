package com.ducktem.ducktemapi.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.ProductTag;
import com.ducktem.ducktemapi.repository.ProductTagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductTagServiceImpl implements ProductTagService{
	private final ProductTagRepository productTagRepository;
	@Override
	public void add(String[] tagNames, Product product) {
		Arrays.stream(tagNames).forEach(tagName -> productTagRepository.save(ProductTag.builder().name(tagName).product(product).build()));
	}

	@Override
	public void delete(Long id) {
		productTagRepository.deleteById(id);
	}
}
