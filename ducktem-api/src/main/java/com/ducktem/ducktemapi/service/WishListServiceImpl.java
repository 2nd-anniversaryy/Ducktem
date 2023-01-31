package com.ducktem.ducktemapi.service;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.entity.Product;
import com.ducktem.ducktemapi.entity.WishList;
import com.ducktem.ducktemapi.repository.MemberRepository;
import com.ducktem.ducktemapi.repository.ProductRepository;
import com.ducktem.ducktemapi.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WishListServiceImpl implements WishListService{

    private final WishListRepository wishListRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Override
    public List<WishList> getList(String memberId) {
        Optional<Member> member = memberRepository.findByUserId(memberId);

        return wishListRepository.findByMember(member.get());
    }

    @Override
    public int confirmWishStatus(Long productId, String memberId) {
        Optional<Member> member = memberRepository.findByUserId(memberId);
        Optional<Product> product = productRepository.findById(productId);

        List<WishList> wishList = wishListRepository.findByProductAndMember(product.get(), member.get());

        if (wishList != null)
            return 1;
        else
            return 0;
    }
}
