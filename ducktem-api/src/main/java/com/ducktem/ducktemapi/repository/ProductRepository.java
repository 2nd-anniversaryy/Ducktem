package com.ducktem.ducktemapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ducktem.ducktemapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	Page<Product> findAll(Pageable pageable);
}
