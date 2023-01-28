package com.ducktem.ducktemapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;

import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.SuperCategory;

import lombok.RequiredArgsConstructor;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


	List<Category>  findBySuperCategory(SuperCategory superCategoryId);

	List<Category> findByIdIn(Integer[] categoryId);
}
