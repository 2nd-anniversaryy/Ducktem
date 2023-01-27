package com.ducktem.ducktemapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

import com.ducktem.ducktemapi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByIdIn(Integer[] categoryId);
}
