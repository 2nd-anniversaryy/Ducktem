package com.ducktem.ducktemapi.service;

import java.util.List;
import java.util.Optional;

import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.SuperCategory;

public interface CategoryService {

	List<Category> getList(Integer superCategoryId);

	List<SuperCategory> getSuperCategoryList();
}
