package com.ducktem.ducktemapi.dto.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class MemberInfoRequest {
	private String nickName;
	private String intro;
	private String email;
	private MultipartFile file;
}