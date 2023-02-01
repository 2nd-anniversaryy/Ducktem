package com.ducktem.ducktemapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long> {
	List<WishList> findByMember(Member member);

	List<WishList> findByProduct(Product product);

	WishList findByProductAndMember(Product product, Member member);

}
