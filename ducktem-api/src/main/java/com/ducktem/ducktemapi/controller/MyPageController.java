package com.ducktem.ducktemapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ducktem.ducktemapi.dto.response.ProductPreviewResponse;
import com.ducktem.ducktemapi.service.MyPageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("mypage")
public class MyPageController {
	private final MyPageService myPageService;
	// 찜 기능 구현과 같이 구현 예정.
	public void myWishList() {

	}
	@GetMapping()
	public ResponseEntity<List<ProductPreviewResponse>> mySellProductList(Authentication authentication){
		return new ResponseEntity<>(myPageService.productList(authentication.getName()), HttpStatus.OK);

	}

}
