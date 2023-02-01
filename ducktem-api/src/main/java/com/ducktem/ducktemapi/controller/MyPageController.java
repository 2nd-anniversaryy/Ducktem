package com.ducktem.ducktemapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
