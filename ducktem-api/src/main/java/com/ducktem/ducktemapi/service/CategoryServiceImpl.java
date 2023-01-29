package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.SuperCategory;
import com.ducktem.ducktemapi.repository.CategoryRepository;
import com.ducktem.ducktemapi.repository.SuperCategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

	private final CategoryRepository categoryRepository;

	private final SuperCategoryRepository superCategoryRepository;

	@Override
	public List<Category> getList(Integer superCategoryId) {
		SuperCategory superCategory= superCategoryRepository.findById(superCategoryId)
			.orElseThrow(()-> new RuntimeException());
		return categoryRepository.findBySuperCategory(superCategory);
	}

	@Override
	public List<SuperCategory> getSuperCategoryList() {
		return superCategoryRepository.findAll();
	}
}
