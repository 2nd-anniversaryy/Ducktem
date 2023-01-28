package com.ducktem.ducktemapi.service;

import com.ducktem.ducktemapi.dto.response.WishListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WishListService {
    List<WishListResponse> getList(String memberId);

}
