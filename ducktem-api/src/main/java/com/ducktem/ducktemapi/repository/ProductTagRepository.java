package com.ducktem.ducktemapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducktem.ducktemapi.entity.ProductTag;

public interface ProductTagRepository extends JpaRepository<ProductTag,Long> {
}
