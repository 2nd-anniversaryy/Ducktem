package com.ducktem.ducktemapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ducktem.ducktemapi.entity.Category;
import com.ducktem.ducktemapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	List<Product> findAllByOrderByIdDesc();

	@Query("SELECT count(p) from Product p where p.name like :query  and p.category in :category")
	Long countProductByNameLikeQuery(@Param("query") String query, @Param("category") List<Category> category);

	//=====정렬
	//최신순
	@Query("from Product p where p.name like :query and p.category in :category  order by p.id desc")
	Page<Product> findByNameQueryAndCategoryInOrderByIdDesc(Pageable pageable, @Param("query") String query, @Param("category") List<Category> category);
	//높은가격순
	@Query("from Product p where p.name like :query and p.category in :category  order by p.price desc")
	Page<Product> findByNameQueryAndCategoryInOrderByPriceDesc(Pageable pageable, @Param("query") String query, @Param("category") List<Category> category);
	//낮은가격순
	@Query("from Product p where p.name like :query and p.category in :category  order by p.price asc ")
	Page<Product> findByNameQueryAndCategoryInOrderByPrice(Pageable pageable, @Param("query") String query, @Param("category") List<Category> category);
	//인기상품순
	@Query("from Product p where p.name like :query and p.category in :category  order by p.hit desc ")
	Page<Product> findByNameQueryAndCategoryInOrderByHit(Pageable pageable, @Param("query") String query, @Param("category") List<Category> category);

}
