package com.ducktem.ducktemapi.service;

import com.ducktem.ducktemapi.entity.WishList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WishListService {
    List<WishList> getList(String memberId);

    int confirmWishStatus(Long productId, String memberId);
}
