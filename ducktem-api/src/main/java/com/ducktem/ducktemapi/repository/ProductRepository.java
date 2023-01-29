package com.ducktem.ducktemapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.SuperCategory;
import com.ducktem.ducktemapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	Page<Product> findAll(Pageable pageable);
	@Query("from Product p where p.name like :query order by p.id desc")
	Page<Product> findByNameQueryOrderByIdDesc(Pageable pageable, String query);
	Page<Product> findByCategoryInOrderByIdDesc(Pageable pageable, List<Category> category);
	@Query("from Product p where p.name like :query and p.category in :category  order by p.id desc")
	Page<Product> findByNameQueryAndCategoryInOrderByIdDesc(Pageable pageable, String query, List<Category> category);
	@Query("SELECT count(p) from Product p where p.name like :query  and p.category in :category")
	Long countProductByNameLikeQuery(String query, List<Category> category);


}
