package com.ducktem.ducktemapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class OauthController {

	@GetMapping("kakao")
	public void kakaoTest(@RequestParam String code){
		System.out.println(code);
	}


}
