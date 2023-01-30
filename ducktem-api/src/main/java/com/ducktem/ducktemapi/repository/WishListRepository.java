package com.ducktem.ducktemapi.repository;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> findByMember(Member member);
    List<WishList> findByProduct(Product product);

    List<WishList> findByProductAndMember(Product product, Member member);
}
