package com.ducktem.ducktemapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.SuperCategory;
import com.ducktem.ducktemapi.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categorys")
public class CategoryController {

	private final CategoryService categoryService;

	@GetMapping("/super")
	public List<SuperCategory> getSuperCategoryList(){
		return categoryService.getSuperCategoryList();
	}

	@GetMapping
	public List<Category> getList(@RequestParam(name="s", defaultValue = "1") Integer superCategoryId){
		return categoryService.getList(superCategoryId);
	}
}
