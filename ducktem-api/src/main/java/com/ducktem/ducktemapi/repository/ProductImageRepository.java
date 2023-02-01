package com.ducktem.ducktemapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducktem.ducktemapi.entity.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
	Optional<List<ProductImage>> findByThumbNail(byte thumbNail);

	Optional<ProductImage> findByName(String name);

}
