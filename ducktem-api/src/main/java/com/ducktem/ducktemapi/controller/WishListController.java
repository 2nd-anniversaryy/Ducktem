package com.ducktem.ducktemapi.controller;

import com.ducktem.ducktemapi.dto.response.WishListResponse;
import com.ducktem.ducktemapi.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("wish")
public class WishListController {

    private final WishListService wishListService;
    @GetMapping
    public List<WishListResponse> getList(Authentication authentication){

        return wishListService.getList(authentication.getName());
    }


}
