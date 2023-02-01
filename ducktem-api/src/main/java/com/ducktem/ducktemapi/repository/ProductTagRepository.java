package com.ducktem.ducktemapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ducktem.ducktemapi.entity.ProductTag;

public interface ProductTagRepository extends JpaRepository<ProductTag,Long> {


	void deleteByProductId(Long id);
}
